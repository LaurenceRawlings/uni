#include <stdio.h>
#include <stdlib.h>

#define MAX_TABLE_SIZE 13

void generate_table(int num, int *table);
void print_table(int num, int *table);

int main(int argc , char *argv[]) {
	if (argc != 2) {
		printf("%s <num>\n where <num> is an integer between 0 and 12\n", argv[0]);
		return -1;
	}

	int num = atoi(argv[1]);
	if (num < 0 || num > 12) {
		printf("Invalid number size! Must be between 0 and 12.\n");
		return -1;
	}
	
	int *values = (int*) malloc(MAX_TABLE_SIZE * sizeof(int));
	generate_table(num, values);
	print_table(num, values);
	free(values);
	values = NULL;
	
	return 0;
}

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
}
