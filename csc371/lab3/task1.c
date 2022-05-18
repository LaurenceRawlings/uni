#include <stdio.h>

#include "constituency.h"

int main(int argc, char *argv []) {
	struct Constituency test;
	construct_Constituency(
		&test,
		"Swansea East",
		(unsigned int[]){1, 2, 3, 4},
		4);
	print_Constituency(&test);
	
	printf("\n");
	
	destruct_Constituency(&test);
	
	return 0;
}