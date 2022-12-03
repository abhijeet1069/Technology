import math as m

def functionA(n):
    if(n == 0):
        return 10
    return functionA(n-1)-3

def functionB(n):
    return (n*(n+1))/2

def functionC(n):
    return m.pow(3,n)-m.pow(2,n)

def functionD(n):
    return m.floor(m.sqrt(n))

def functionE(n):
    if(n == 0):
        return 1
    if(n == 1):
        return 5
    return functionE(n-1)+functionE(n-2)

def functionF(n):
    sum=0
    for i in range(0,n):
        sum += m.pow(2,i)
    return sum
    
def main():
    for n in range(1,11):
        print(functionF(n), end=", ")

if __name__=="__main__":
    main()