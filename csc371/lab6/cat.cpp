#include <iostream>
#include "cat.hpp"

Cat::Cat()
    : name("Tom"), lives(9)
{
}

Cat::Cat(std::string name)
    : name(name), lives(9)
{
}

Cat::Cat(std::string name, unsigned int lives)
    : name(name), lives(lives)
{
}

std::string Cat::get_name() const
{
    return name;
}

unsigned int Cat::get_lives() const
{
    return lives;
}

void Cat::set_name(std::string const name)
{
    this->name = name;
}

void Cat::set_lives(unsigned int const lives)
{
    if (lives >= this->lives)
        return;

    if (this->lives > 0 && lives == 0)
    {
        this->set_name("The Cat formerly known as " + this->get_name());
    }

    this->lives = lives;
}

std::ostream& operator<<(std::ostream &os, const Cat &cat) {
    return os << cat.name << " has " << cat.lives << " lives...";
}

bool operator==(const Cat& lhs, const Cat& rhs) {
    return lhs.name == rhs.name && lhs.lives == rhs.lives;
}

bool operator<(const Cat &lhs, const Cat &rhs) {
    if (lhs.name == rhs.name) {
        return lhs.lives < rhs.lives;
    }
    else {
        return lhs.name < rhs.name;
    }
}
