# myRSA
from Crypto.Util.number import getPrime,bytes_to_long as b2l
from math import gcd
import hashlib
import random
import socketserver


KEYSIZE = 512
alpha = 2.0314159265358979
WELCOME = 'Welcome to use my better RSA!!!!!!So, what do you want now?'
menu = '1. encry \n2. getflag\n3. exit'
String = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz'

def proof_of_work():
    STR = ''.join([String[random.randint(0,len(String)-1)] for _ in range(16) ])
    HASH = hashlib.sha256(STR.encode()).hexdigest()
    return STR[:4],STR[4:],HASH

def key_gen():
    while True:
        p,q = getPrime(KEYSIZE),getPrime(KEYSIZE)
        e = 0x10001
        if gcd(e,(p-1)*(q-1)):
            break
    key = [getPrime(int(KEYSIZE*alpha)) for _ in range(128)]
    return (p,q,e),key

# encrypto
def encry(message,key,p,q,e):
    k1,k2 = key[random.randint(0,127)],key[random.randint(0,127)]
    x = p**2 * (p + 3*q - 1 ) + q**2 * (q + 3*p - 1) 
    y = 2*p*q + p + q
    z = k1 + k2 
    c = pow(b2l(message),e,p*q)
    return x * c + y * c + z


# get flag
def getflag(flag,key,p,q,e):
    return encry(flag,key,p,q,e)



class server(socketserver.BaseRequestHandler):
    def _recv(self):
        data = self.request.recv(1024)
        return data.strip()

    def _send(self, msg, newline=True):
        if isinstance(msg , bytes):
            msg += b'\n'
        else:
            msg += '\n'
            msg = msg.encode()
        self.request.sendall(msg)

    def handle(self):
        START,END,HASH = proof_of_work()
        self._send('SHA-256(?+{}) == {}'.format(END,HASH))
        RCV = self._recv().decode()
        if RCV != START:
            return
        self._send("I'm a CryptoRookie,so my Crypto system take time, please wait a minute XD!")
        (p,q,e),key = key_gen()
        flag  = open('flag','rb').read()
        self._send(WELCOME)
        self._send('This is my public key:\nn = {}\ne = {}'.format(str(p*q),str(e)))
        for _ in range(16):
            self._send(menu)
            COI = int(self._recv().decode())
            if COI == 1 :
                self._send('Give me your message')
                message = self._recv()
                self._send('Your encry message:')
                self._send(str(encry(message,key,p,q,e)))
            elif COI == 2:
                self._send('This is your favourite:\n')
                self._send(str(encry(flag,key,p,q,e)))
            elif COI == 3:
                self._send('Bye~')
                break
class ForkedServer(socketserver.ThreadingMixIn, socketserver.TCPServer):
    pass

if __name__ == "__main__":
    HOST, PORT = '0.0.0.0', 10001
    server = ForkedServer((HOST, PORT), server)
    server.allow_reuse_address = True
    server.serve_forever()

