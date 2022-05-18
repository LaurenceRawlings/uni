#ifndef INTVECTOR_H_
#define INTVECTOR_H_

class IntVector
{
private:
    unsigned int pos;
    unsigned int length;
    int *data;

public:
    IntVector();
    ~IntVector();
    void resize(const unsigned int new_length);
    void push(const int value);
    int pop();
    void print();
};

#endif // INTVECTOR_H_