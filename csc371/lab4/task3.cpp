#include <iostream>
#include <cmath>
#include "cat.h"

int main(int argc, char *argv[])
{
    if (argc <= 1)
    {
        std::cout << "No arguments passed..." << std::endl;
        return 0;
    }

    const bool odd_args = !((argc - 1) % 2 == 0);
    const int num_cats = std::ceil((argc - 1) / 2.0);

    std::cout << "Allocating clowder of size " << num_cats << std::endl;
    Cat *cats = new Cat[num_cats];

    for (int i = 0; i < num_cats; i++)
    {
        if (odd_args && i == num_cats - 1)
        {
            Cat cat = Cat(argv[i*2 + 1]);
            cats[i] = std::move(cat);
        }
        else
        {
            Cat cat = Cat(argv[i*2 + 1], std::stoi(argv[i*2 + 2], nullptr, 10));
            cats[i] = std::move(cat);
        }
    }

    for (int i = 0; i < num_cats; i++)
    {
        std::cout << cats[i].get_name() << " has "
            << cats[i].get_lives() << " lives." << std::endl;
    }

    delete[] cats;
}