#include <iostream>
#include "intvector.hpp"

IntVector::IntVector()
    : pos(0), length(0), data(nullptr)
{
    this->resize(length);
}

IntVector::~IntVector()
{
    if (this->data != NULL)
    {
        free(this->data);
        this->data = nullptr;
    }

    this->pos = 0;
    this->length = 0;
}

void IntVector::push(const int value)
{
    if (this->pos > this->length - 1)
    {
        this->resize(this->length * 2);
    }

    this->data[this->pos++] = value;
}

int IntVector::pop()
{
    if (this->pos <= 0)
    {
        std::cout << "Cannot pop item from empty vector!" << std::endl;
        return 0;
    }

    return this->data[--(this->pos)];
}

void IntVector::resize(const unsigned int new_length)
{
    if (new_length > 0)
    {
        this->data = (int *)realloc(this->data, sizeof(int) * new_length);
        this->length = new_length;
    }
    else
    {
        this->~IntVector();
    }
}

void IntVector::print()
{
    printf("%p [ ", iv->data);
    
    int i;
    for (i = 0; i < iv->pos; i++)
    {
        printf("%d ", iv->data[i]);
    }

    printf(
        "] (used capacity = %d, spare = %d, total = %d)\n",
        iv->pos,
        iv->length - iv->pos,
        iv->length);
}