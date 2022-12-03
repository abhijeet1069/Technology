import math as m

for n in range(0,4):
    tempA = m.pow(2,n)+1
    tempB = m.pow(n+1,n+1)
    tempC = m.floor(n/2)
    tempD = m.floor(n/2)+m.ceil(n/2)
    print("n={0}, a={1}, b={2}, c={3}, d={4}".format(n,tempA,tempB,tempC,tempD))

