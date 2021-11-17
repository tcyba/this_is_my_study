from Crypto.Util.number import (
    bytes_to_long,
    getPrime,
    long_to_bytes,
    getRandomNBitInteger,
)
import random
import hashlib
from math import gcd
import socketserver


KEYSIZE = 512
WELCOME = "welcome to my funny challenge !!! Can you guess right 32 times in a row? "
String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz"

def exgcd(a, b):
    if b == 0:
        return 1, 0, a
    else:
        x, y, q = exgcd(b, a % b)
        x, y = y, (x - (a // b) * y)
        return x, y, q


def invert(a,p):
    x, y, q = exgcd(a,p)
    if q != 1:
        raise Exception("No solution.")
    else:
        return (x + p) % p

def lcm(a,b):
    return a*b // gcd(a,b)

def proof_of_work():
    STR = "".join([String[random.randint(0, len(String) - 1)] for _ in range(16)])
    HASH = hashlib.sha256(STR.encode()).hexdigest()
    return STR[:4], STR[4:], HASH


def keygen():
    # part 1
    p, q = getPrime(KEYSIZE), getPrime(KEYSIZE)
    n = p * q
    g = n + 1
    LAMBDA = lcm(p - 1, q - 1)

    # part 2
    _key = open("key", "r").read()
    key = []
    for i in _key.split("\n"):
        for j in i[1:-1].split(" "):
            if int(j) not in key:
                key.append(int(j))
    assert len(key) == 80
    assert key[0] == 119 and key[1] ==  241 and key[2] ==  718 and key[3] == 647
    return n, g, LAMBDA, key


def enc(n, g, m):
    while 1:
        r = random.randint(2, n - 1)
        if gcd(r, n) == 1:
            break
    c = (pow(g, m, n ** 2) * pow(r, n, n ** 2)) % (n ** 2)
    return c


def dec(n, g, LAMBDA, c):
    L1 = (pow(c, LAMBDA, n ** 2) - 1) // n
    L2 = (pow(g, LAMBDA, n ** 2) - 1) // n
    m = (invert(L2, n) * L1) % n
    return m


class server(socketserver.BaseRequestHandler):
    def _recv(self):
        data = self.request.recv(1024)
        return data.strip()

    def _send(self, msg, newline=True):
        if isinstance(msg, bytes):
            msg += b"\n"
        else:
            msg += "\n"
            msg = msg.encode()
        self.request.sendall(msg)

    def handle(self):
        print("Service start.")
        START, END, HASH = proof_of_work()
        self._send("SHA-256(?+{}) == {}".format(END, HASH))
        RCV = self._recv().decode()
        if RCV != START:
            return
        flag = open("flag", "rb").read()
        self._send(WELCOME)
        # step 1. KeyGen
        for _ in range(32):
            self._send("round " + str(_+1))
            n, g, LAM, KEY = keygen()
            self._send("Step 1 - KeyGen. This is my public key.")
            self._send("n = " + str(n))
            self._send("g = " + str(g))
            # step 2. Phase 1
            self._send(
                "Step 2 - Phase 1. Now, you can give me one ciphertexts,I will return the corresponding plaintext."
            )

            self._send("Please give me one decimal ciphertext.")
            cipher = int(self._recv().decode())
            plaintext = str(dec(n, g, LAM, cipher))
            self._send("This is the corresponding plaintext.")
            self._send(plaintext)

            # step 3. challenge
            self._send(
                "Step 3 - Challenge. Now, you must give me two decimal plaintexts(m0,m1), I will encry them and return a ciphertext randomly"
            )
            self._send("Give me m0.")
            plaintext1 = int(self._recv().decode())
            self._send("Give me m1.")
            plaintext2 = int(self._recv().decode())

            if (
                plaintext1 <= 2
                or plaintext2 <= 2
                or len(bin(plaintext1)) != len(bin(plaintext2))
            ):
                return
            R = 2 * random.randint(0, 39)
            I = random.randint(0, 1)
            cipher1 = enc(n, g, plaintext1 * plaintext2 * KEY[R])
            cipher2 = enc(n, g, plaintext1 * plaintext2 * KEY[R + 1])
            self._send("This is a ciphertext.")
            self._send(str([cipher1, cipher2][I]))

            # step 4. Phase 2

            self._send(
                "Step 4 - Phase 2. Now, you can give me some ciphertexts,I will return the corresponding plaintext.But you can not give me the ciphertext that I give you in step 3."
            )
            self._send("Please give me one decimal ciphertext ")
            cipher = int(self._recv().decode())
            plaintext = str(dec(n, g, LAM, cipher))
            if int(plaintext) == plaintext1 * plaintext2 * KEY[R] or int(plaintext) == plaintext1 * plaintext2 * KEY[R+1]:
                return
            self._send("This is the corresponding plaintext.")
            self._send(plaintext)

            # step.5 Guess
            self._send(
                "Step 5 - Guess. You must tell me which ciphertext was I give you in step 3, 0 or 1(m0 -> c0 , m1 -> c1)?"
            )
            Guess = int(self._recv().decode())

            if Guess == I:
                self._send("Good! You are right")
            else:
                self._send("Sorry!")
                return
        self._send(flag)

class ForkedServer(socketserver.ThreadingMixIn, socketserver.TCPServer):
    pass


if __name__ == "__main__":
    HOST, PORT = "0.0.0.0", 10001
    server = ForkedServer((HOST, PORT), server)
    server.allow_reuse_address = True
    server.serve_forever()
