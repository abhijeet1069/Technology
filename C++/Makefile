APP_NAME = myApp
BUILD_DIR = ./bin
CPP_FILES = ./src/header-files/*.cpp

all: build run

build:
	c++ $(CPP_FILES) -o $(BUILD_DIR)/$(APP_NAME)

run:
	$(BUILD_DIR)/$(APP_NAME)

object:
	c++ $(CPP_FILES) -c -o $(BUILD_DIR)/$(APP_NAME).o