APP_NAME = myApp
BUILD_DIR = ./bin
CPP_FILES = ./src/9-threads.cpp

all: build run

build:
	c++ $(CPP_FILES) -o $(BUILD_DIR)/$(APP_NAME) -std=c++14

run:
	$(BUILD_DIR)/$(APP_NAME)

object:
	c++ $(CPP_FILES) -c -o $(BUILD_DIR)/$(APP_NAME).o