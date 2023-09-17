APP_NAME1 = myApp1
APP_NAME2 = myApp2
BUILD_DIR = ./bin/redirection
C_FILE1 = ./src/redirection/count.c
C_FILE2 = ./src/redirection/hello.c
C_FLAGS = -std=c11

all: build run

build:
	clang $(C_FLAGS) $(C_FILE1) -o $(BUILD_DIR)/$(APP_NAME1)
	clang $(C_FLAGS) $(C_FILE2) -o $(BUILD_DIR)/$(APP_NAME2)

run:
	$(BUILD_DIR)/$(APP_NAME)