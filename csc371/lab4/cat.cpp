#include <iostream>
#include "cat.hpp"

Cat::Cat()
    : name("Tom"), lives(9)
{
    std::cout << "Default constructor called..." << std::endl;
}

Cat::Cat(std::string name)
    : name(name), lives(9)
{
    std::cout << "Constructor called with name..." << std::endl;
}

Cat::Cat(std::string name, unsigned int lives)
    : name(name), lives(lives)
{
    std::cout << "Constructor called with name and lives..." << std::endl;
}

Cat::~Cat()
{
    std::cout << "Destructor called..." << std::endl;
}

std::string Cat::get_name() const
{
    return name;
}

unsigned int Cat::get_lives() const
{
    return lives;
}

void Cat::set_name(std::string const name) {
    std::cout << "set_name called..." << std::endl;
    this->name = name;
}

void Cat::set_lives(unsigned int const lives) {
    std::cout << "set_lives called..." << std::endl;

    if (lives >= this->lives) return;

    if (this->lives > 0 && lives == 0) {
        this->set_name("The Cat formerly known as " + this->get_name());
    }

    this->lives = lives;
}