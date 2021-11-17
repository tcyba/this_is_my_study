from sage.modules.free_module_integer import IntegerLattice
from sage.stats.distributions.discrete_gaussian_integer import DiscreteGaussianDistributionIntegerSampler
from sage.crypto.lwe import LWE
from sage.crypto.lwe import samples 
import numpy as np
import signal

def Question(n,m,para_D,para_e):  
	signal.alarm(600)     
	print('[+] Question:') 
	# m=n^2-2
	q=next_prime(n^2)                           
	D=DiscreteGaussianDistributionIntegerSampler(para_D*n)
	lwe=LWE(n=n, q=q, D=D)
	Z=[lwe() for _ in range(m)]
	A=matrix([a for (a,c) in Z]).transpose()
	C=vector([c for (a,c) in Z])
	print('[+] The following matrix operations are modulus',q)
	print('\n[+] Matrix A of size',n,'*',m,':'); print(A)
	print('\n[+] Vector C of size',1,'*',m,':'); print(np.array(C))
	E=lwe._LWE__s*A-C
	E=[int(e) for e in E]
	E=vector([e if e <= floor(q/2) else e-q for e in E])
	E_norm=E.norm().n()*para_e
	print('[+] Please give an integer vector x of size',1,'*',m,'(format [1 2 3] or [1, 2, 3]), such that the norm of vector x*A-C <=',E_norm,', where operations are modulus',q,':')
	k=GF(q)^n
	x=k(0)
	u=input()
	try:
		u=np.matrix(u)
		for i in range(n):
			x[i]=u[0,i]
	except:
		print('[+] Wrong format, exit.')
		exit()
	E=x*A-C
	E=[int(e) for e in E]
	E=vector([e if e <= floor(q/2) else e-q for e in E])
	tmp=E.norm().n()
	print('[+] The norm of vector x*A-C is', tmp,',', tmp<E_norm,'.\n')
	if not tmp<E_norm:
		exit()
	

def ReadFlag():
	print('flag{**********}')

Question(5, 23, 1.5, 1.1)
Question(15, 143, 1.5, 3)
ReadFlag()





