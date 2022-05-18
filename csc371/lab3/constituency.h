#ifndef CONSTITUENCY_H_
#define CONSTITUENCY_H_

struct Constituency {
    char *name;
    unsigned int *neighbours;
    unsigned int num_neighbours;
};

void construct_Constituency(struct Constituency * const constituency, char const *name, unsigned int * const neighbours, unsigned int const num_neighbours);
void destruct_Constituency(struct Constituency * const constituency);
void print_Constituency(struct Constituency * const constituency);
int load_Constituencies(char const *filepath, struct Constituency ** const out_constituencies, unsigned int * const out_num_constituencies);

#endif // CONSTITUENCY_H_