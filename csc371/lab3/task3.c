#include <stdio.h>
#include <stdlib.h>
#include "constituency.h"

int main(int argc, char *argv[]) {
	struct Constituency *constituencies;
	unsigned int num_constituencies;
	
	if (!load_Constituencies("wales.graph", &constituencies, &num_constituencies)) {
		return -1;
	}
	
	int max_neighbours = 0;
	int min_neighbours = 0;

	int i;
	for (i = 0; i < num_constituencies; i++) {
		if (constituencies[i].num_neighbours > constituencies[max_neighbours].num_neighbours) {
			max_neighbours = i;
		}

		if (constituencies[i].num_neighbours < constituencies[min_neighbours].num_neighbours) {
			min_neighbours = i;
		}

		print_Constituency(&constituencies[i]);
		printf("\n");
	}

	printf("\n%s has the most bordering constituencies:\n", constituencies[max_neighbours].name);

	for (i = 0; i < constituencies[max_neighbours].num_neighbours; i++) {
		printf("\t%s\n", constituencies[constituencies[max_neighbours].neighbours[i]].name);
	}

	printf("\n%s has the fewest bordering constituencies:\n", constituencies[min_neighbours].name);

	for (i = 0; i < constituencies[min_neighbours].num_neighbours; i++) {
		printf("\t%s\n", constituencies[constituencies[min_neighbours].neighbours[i]].name);
	}

	for (i = 0; i < num_constituencies; i++) {
		destruct_Constituency(&constituencies[i]);
	}

	free(constituencies);

	return 0;
}