//Syntax sugar for pointers

#include<iostream>

#define LOG(x) std::cout<< x << std::endl;



int main(){
    int a = 5;
    int& ref = a; //ref is like an alias to a

    ref = 2;

    LOG(ref);
    LOG(a);
}