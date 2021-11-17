from Crypto.Util.number import getRandomNBitInteger

while 1:
    A = []
    key = random_matrix(ZZ, 20, 4, x = 100, y =1000)
    for i in range(20):
        for j in range(4):
            if key[i,j] not in A:   
                A.append(key[i,j])
    if len(A) == 80:
        break
hint = Matrix(key * vector([getRandomNBitInteger(1024) for _ in range(4)]) for _ in range(12))
open('key','w').write(str(key))
open('hint','w').write(str(hint))

