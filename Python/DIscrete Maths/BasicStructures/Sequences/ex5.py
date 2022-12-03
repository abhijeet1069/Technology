import math as m

def functionA(n):
    if(n == 0):
        return 2
    return functionA(n-1)+3

def functionD(n):
    return m.factorial(n)-m.pow(2,n)

def functionE(n):
    if(n == 0):
        return 3
    return 2*functionE(n-1)

def functionF(n):
    if(n == 0):
        return 2
    if(n == 1):
        return 4
    return (functionF(n-1)+functionF(n-2))

def functionG(n):
    #bits required to store a binary number
    return m.floor(m.log2(n))+1 

def main():
    for i in range(1,11):
        print(functionG(i))

if __name__=="__main__":
    main()