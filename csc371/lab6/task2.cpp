#include <iostream>
#include <unordered_set>

#include "cat.hpp"

int main(int argc, char *argv[])
{

    std::unordered_set<Cat> unique_cats;
    unique_cats.insert(Cat("Garfield", 42));
    unique_cats.insert(Cat("Garfield", 10));
    unique_cats.insert(Cat("Catbert", 666));
    unique_cats.insert(Cat("Toothless", 13));
    unique_cats.insert(Cat("Garfield", 42));
    unique_cats.insert(Cat("Garfield", 42));

    std::cout << std::endl
              << "Unique Cats" << std::endl;
    for (auto it = unique_cats.begin(); it != unique_cats.end(); it++)
    {
        std::cout << *it << std::endl;
    }

    return 0;
}