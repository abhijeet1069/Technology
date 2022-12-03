import math as m

for n in range(0,4):
    tempA = m.pow(-2,n)
    tempB = 3
    tempC = 7+m.pow(4,n)
    tempD = m.pow(2,n)+m.pow(-2,n)
    print("n={0}, a={1}, b={2}, c={3}, d={4}".format(n,tempA,tempB,tempC,tempD))

