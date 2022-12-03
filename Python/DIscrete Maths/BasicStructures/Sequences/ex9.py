def functionA(n):
    if(n == 0):
        return 2
    return 6*functionA(n-1)

def functionB(n):
    

def main():
    for n in range(1,11):
        print(functionA(n), end=", ")

if __name__=="__main__":
    main()