/*
A pointer is just an address for any type of data
*/

#include<iostream>

#define LOG(x) std::cout << x << std::endl;

int main(){
    /* Version 1
    int var = 8;
    int *ptr = &var;
    *ptr = 10; //dereferencing the pointer. void *ptr won't work as compiler dosen't know how much data to write
    LOG(var);
    */

   char * buffer = new char[8]; //new allocates memory and returns address to the start of memory block
   memset(buffer,0,8); //Set buffer to zero of size 8 bytes

   char **ptr = &buffer;
   delete[] buffer; //memory was allocated in heap. So, need to be cleared.
}