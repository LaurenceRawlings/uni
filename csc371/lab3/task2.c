#include <stdio.h>

#include "constituency.h"

int main(int argc, char *argv[])
{
	const int num_constituencies = 5;
	struct Constituency constituencies[num_constituencies];

	construct_Constituency(
		&constituencies[0], "Swansea East",
		(unsigned int[]){1, 2, 3, 4}, 4);

	construct_Constituency(
		&constituencies[1], "Swansea West",
		(unsigned int[]){0, 2}, 2);

	construct_Constituency(
		&constituencies[2], "Gower",
		(unsigned int[]){0, 1, 3}, 3);

	construct_Constituency(
		&constituencies[3], "Neath",
		(unsigned int[]){0, 2, 4}, 3);

	construct_Constituency(
		&constituencies[4], "Aberavon",
		(unsigned int[]){0, 3}, 2);

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

	return 0;
}