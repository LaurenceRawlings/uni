#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "constituency.h"

void construct_Constituency(struct Constituency *const constituency, char const *name, unsigned int *const neighbours, unsigned int const num_neighbours)
{
    constituency->name = NULL;
    constituency->neighbours = NULL;
    constituency->num_neighbours = 0;

    int name_length = strlen(name);

    constituency->name = (char *)malloc((name_length + 1) * sizeof(char));
    constituency->neighbours = (unsigned int *)malloc(num_neighbours * sizeof(unsigned int));

    memcpy(constituency->name, name, name_length * sizeof(char));
    if (num_neighbours > 0)
    {
        memcpy(constituency->neighbours, neighbours, num_neighbours * sizeof(unsigned int));
    }

    constituency->num_neighbours = num_neighbours;
}

void destruct_Constituency(struct Constituency *const constituency)
{
    if (constituency->name != NULL)
    {
        free(constituency->name);
        constituency->name = NULL;
    }

    if (constituency->neighbours != NULL)
    {
        free(constituency->neighbours);
        constituency->neighbours = NULL;
    }

    constituency->num_neighbours = 0;
}

void print_Constituency(struct Constituency *const constituency)
{
    printf("%s | %u neighbours | [ ", constituency->name, constituency->num_neighbours);
    int i;
    for (i = 0; i < constituency->num_neighbours; i++)
    {
        printf("%u ", constituency->neighbours[i]);
    }

    printf("]");
}

int load_Constituencies(char const *filepath, struct Constituency **const out_constituencies, unsigned int *const out_num_constituencies)
{
    FILE *fp;
    int line = 1;
    fp = fopen(filepath, "r");
    if (fp == NULL)
    {
        *out_constituencies = NULL;
        *out_num_constituencies = 0;
        printf("Could not open file \"%s\"\n", filepath);
        return 0;
    }

    unsigned int num_constituencies;
    if (!fscanf(fp, "%u\n", &num_constituencies))
    {
        printf("Could not read num of constituencies\n");
        return 0;
    }

    *out_constituencies = (struct Constituency *) malloc(num_constituencies * sizeof(struct Constituency));

    int i;
    for (i = 0; i < num_constituencies; i++)
    {
        unsigned int num_neighbours;
        if (!fscanf(fp, "%u,", &num_neighbours))
        {
            printf("Could not read num of neighbours\n");
            return 0;
        }

        int j;
        unsigned int neighbours[num_neighbours];
        for (j = 0; j < num_neighbours; j++)
        {
            if (!fscanf(fp, "%u,", &neighbours[j]))
            {
                printf("Could not read neighbour\n");
                return 0;
            }
        }

        char current_char = 'a';
        long name_start = ftell(fp);
        while (current_char != '\n')
        {
            if (!fscanf(fp, "%c", &current_char))
            {
                printf("Could not read name\n");
                return 0;
            }
        }
        long name_end = ftell(fp);
        int name_len = (int) (name_end - name_start);
        fseek(fp, name_start, SEEK_SET);

        char name[name_len];

        if (!fscanf(fp, "%s\n", name))
        {
            printf("Could not read name\n");
            return 0;
        }

        construct_Constituency(
            &((*out_constituencies)[i]),
            name,
            neighbours,
            num_neighbours);
    }

    *out_num_constituencies = num_constituencies;

    return 1;
}