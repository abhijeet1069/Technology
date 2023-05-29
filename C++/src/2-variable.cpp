/**
Primitive variables have inherently no difference between them except size. 
char = 1 byte
short = 2 bytes
int = 4 bytes (depends on compiler)
long = 8 bytes

float = 4 bytes . F required at the end, else its treated as double
double = 8 bytes

unsigned - use the full size, even the space reserved for sign
*/

#include<iostream>

int main(){
    float variable = 8.4;
    std::cout<<sizeof(variable)<<std::endl;
    return 0;
}