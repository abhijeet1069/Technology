#include<iostream>

/*
Only main() function is exempt of return type, despite having return type as int.
*/

int multiply(int a, int b){
    return a*b;
}

int main(){
    int result = multiply(3,4);
    std::cout<<result<<std::endl;
    }