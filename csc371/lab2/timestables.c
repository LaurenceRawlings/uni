#include <stdio.h>
#include "timestables.h"
# include "arrays.h"

void generate_table(int num, int *table) {
	int i;
	for (i = 0; i < MAX_TABLE_SIZE; i++) {
		table[i] = i * num;
	}
}

void print_table(int num, int *table) {
	printf("%-2d times table\n--------------\n", num);
	int i;
	for (i = 0; i < MAX_TABLE_SIZE; i++) {
		printf("%-2d * %-2d = %d\n", num, i, *(table+i));
	}
	printf("\n");
	double mean_value = mean(MAX_TABLE_SIZE, table);
	printf("The mean for this table is %f\n\n", mean_value);
}

// Loops through and calls the function to print each times table
// up to the maximun number defined in the header file
void print_tables(int **tables) {
    int i;
    for (i = 0; i <= MAX_TIMES_TABLE; i++) {
        print_table(i, tables[i]);
    }
}
