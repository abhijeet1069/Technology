#include<iostream>

/*
    Static makes a variable/function visible only to the translation unit in which it exists.

            static.cpp                 main.cpp                             Output
    static int s_Variable = 5;         int s_variable = 10                   10
    int s_Variable = 5;                static int s_variable = 10            10
    int s_Variable = 5;                int s_variable = 10                   linker error:duplicate symbol
    static int s_Variable = 5;         static static int s_variable = 10     10
*/

 extern int s_Variable; //output 5; Won't work if s_Variable is static in static.cpp, also we can't initialize variable here

int main(){
    std::cout<<s_Variable<<std::endl;
}