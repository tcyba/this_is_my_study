print 'Try to solve the 3 ECC'

from secret import flag
from Crypto.Util.number import *
assert(flag[:5]=='flag{')
flag = flag[5:-1]
num1 = bytes_to_long(flag[:7])
num2 = bytes_to_long(flag[7:14])
num3 = bytes_to_long(flag[14:])

def ECC1(num):
	p = 146808027458411567
	A = 46056180
	B = 2316783294673
	E = EllipticCurve(GF(p),[A,B])
	P = E.random_point() 
	Q = num*P
	print E
	print 'P:',P
	print 'Q:',Q

def ECC2(num):
	p = 1256438680873352167711863680253958927079458741172412327087203
	#import random
	#A = random.randrange(389718923781273978681723687163812)
	#B = random.randrange(816378675675716537126387613131232121431231)
	A = 377999945830334462584412960368612
	B = 604811648267717218711247799143415167229480
	E = EllipticCurve(GF(p),[A,B])
	P = E.random_point() 
	Q = num*P
	print E
	print 'P:',P
	print 'Q:',Q
	factors, exponents = zip(*factor(E.order()))
	primes = [factors[i] ^ exponents[i] for i in range(len(factors))][:-1]
	print primes
	dlogs = []
	for fac in primes:
		t = int(int(P.order()) / int(fac))
		dlog = discrete_log(t*Q,t*P,operation="+")
		dlogs += [dlog]
		print("factor: "+str(fac)+", Discrete Log: "+str(dlog)) #calculates discrete logarithm for each prime order
	print num
	print crt(dlogs,primes)



def ECC3(num):
	p = 0xd3ceec4c84af8fa5f3e9af91e00cabacaaaecec3da619400e29a25abececfdc9bd678e2708a58acb1bd15370acc39c596807dab6229dca11fd3a217510258d1b
	A = 0x95fc77eb3119991a0022168c83eee7178e6c3eeaf75e0fdf1853b8ef4cb97a9058c271ee193b8b27938a07052f918c35eccb027b0b168b4e2566b247b91dc07
	B = 0x926b0e42376d112ca971569a8d3b3eda12172dfb4929aea13da7f10fb81f3b96bf1e28b4a396a1fcf38d80b463582e45d06a548e0dc0d567fc668bd119c346b2
	E = EllipticCurve(GF(p),[A,B])
	P = E.random_point() 
	Q = num*P
	print E
	print 'P:',P
	print 'Q:',Q

ECC1(num1)
print '=============='
ECC2(num2)
print '=============='
ECC3(num3)

