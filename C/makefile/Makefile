APP_NAME = myApp
BUILD_DIR = ./bin
C_FILES = ./src/*.c

all: build run

build:
	clang $(C_FILES) -o $(BUILD_DIR)/$(APP_NAME)

run:
	$(BUILD_DIR)/$(APP_NAME)