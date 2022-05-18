#include <stdio.h>
#include "fibonacci.h"
#define FIBONACCI_NUM 10

int main(int argc, char* argv[]) {
    int result = fibonacci(FIBONACCI_NUM);
    printf("Fibonacci of %d = %d\n", FIBONACCI_NUM, result);
    return 0;
}