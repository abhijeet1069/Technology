import math as m

def fun(x):
    temp1 = 2*m.pow(-3,x) + m.pow(5,x)
    print("x = {0} f(x) = {1}".format(x,temp1))

def main():
    fun(5)

if __name__=="__main__":
    main()