.PHONY: build clean test

build: src/main.cpp
	mkdir -p bin
	g++ $^ -o bin/calculator
	bin/calculator

test: test/test.cpp
	mkdir -p bin
	g++ $^ -o bin/test
	bin/test

clean:
	rm -rf bin doc src/main