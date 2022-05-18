#include <stdio.h>
#include <stdlib.h>
#include "fibonacci.h"
#define FIBONACCI_NUM 10

int main(int argc, char* argv[]) {
    int result;

    if (argc == 2) {
        int num = atoi(argv[1]);
        result = fibonacci(atoi(argv[1]));
        printf("Fibonacci of %d = %d\n", num, result);
    } else {
        result = fibonacci(FIBONACCI_NUM);
        printf("Fibonacci of %d = %d\n", FIBONACCI_NUM, result);
    }

    return 0;
}