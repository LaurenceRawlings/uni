#include <stdio.h>
#include <stdlib.h>
#include "timestables.h"

int main(int argc , char *argv[]) {
	int *tables[MAX_TIMES_TABLE];

	int i = 0;
	for (i = 0; i <= MAX_TIMES_TABLE; i++) {
		tables[i] = (int*) malloc(MAX_TABLE_SIZE * sizeof(int));
		generate_table(i, tables[i]);
	}
	
	print_tables(tables);

	i = 0;
	for (i = 0; i <= MAX_TIMES_TABLE; i++) {
		free(tables[i]);
		tables[i] = NULL;
	}
	
	return 0;
}
