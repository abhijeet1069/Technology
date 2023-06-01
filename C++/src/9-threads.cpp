#include<iostream>
#include<thread>
#include<chrono>

//wait for user input and print on console at the same time
//finally a program that is responsive even when continuous printing happens

static bool s_Finished = false;

void doWork(){
    using namespace std::literals::chrono_literals;

    while(!s_Finished){
        std::cout<<"Working...\n";
        //C=+ 14 standard
        std::this_thread::sleep_for(0.1s); //put this thread to sleep, as full speed printing could over-utilize CPU
    }
    std::cout<<"Worker stopped!!"<<std::endl;
}

int main(){
    std::thread worker(doWork);

    std::cin.get(); //block entire main thread till keypress
    s_Finished = true;
    worker.join(); //block the main thread and wait for worker thread to complete

    std::cout<<"Main stopped!!"<<std::endl;
}