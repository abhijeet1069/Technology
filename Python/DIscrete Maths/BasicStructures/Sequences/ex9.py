def functionA(n):
    if(n == 0):
        return 2
    return 6*functionA(n-1)

def functionB(n):
    if(n == 1):
        return 2
    return functionB(n-1)*functionB(n-1)

def functionC(n):
    if(n == 0):
        return 1
    if(n == 1):
        return 2
    return functionC(n-1) + (3*functionC(n-2))

def functionD(n):
    if(n == 0):
        return 1
    if(n == 1):
        return 1
    return (n*functionD(n-1)) + (n*n*functionD(n-2))

def functionE(n):
    if(n == 0):
        return 1
    if(n == 1):
        return 2
    if(n == 2):
        return 0
    return functionE(n-1)+functionE(n-3)

def main():
    for n in range(0,5):
        print(functionA(n), end=", ")

if __name__=="__main__":
    main()