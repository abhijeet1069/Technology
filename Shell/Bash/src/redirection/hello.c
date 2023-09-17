#include<stdio.h>
/**
stdout of hello.c connected to stdin of count.c
    ./bin/redirection/myApp2 | ./bin/redirection/myApp1
**/

int main(int argc, char* argv[]){
    printf("Hello Satyam!!\n");
    return 0;
}