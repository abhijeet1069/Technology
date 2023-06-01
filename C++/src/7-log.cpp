#include<iostream>

/*
    starter level code for logging. Not production level.
*/

class Log{
    public:
        const int LogLevelError = 0; //print eror
        const int LogLevelWarning = 1; //print only error,warning
        const int LogLevelInfo = 2; //print error,warning,info

    private:
        int m_LogLevel; //convention for member variables
    public:
        void setLevel(int level){
            m_LogLevel = level;
        }

        void info(const char* message){
            if(m_LogLevel >= LogLevelError){
                std::cout<<"[INFO]: " << message<<std::endl;
            }
        }

        void warn(const char* message){
            if(m_LogLevel >= LogLevelWarning){
                std::cout<<"[WARNING]: " << message<<std::endl;
            }
        }

        void error(const char* message){
            if(m_LogLevel >= LogLevelInfo){
                std::cout<<"[ERROR]: " << message<<std::endl;
            }
        }
};

int main(){
    Log log;
    log.setLevel(log.LogLevelError);
    log.warn("Hello!");
    log.error("Hello!");
    log.info("Hello!");
}