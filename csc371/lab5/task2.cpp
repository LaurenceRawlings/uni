#include <iostream>
#include "Shape.hpp"

int main(int argc , char *argv[]) {
    Shape *x = new Rectangle(0, 1, 1, 0);
    
    std::cout << x->to_string() << std::endl;
    x->centre_at(-2.5, 2.5);
    
    std::cout << x->to_string() << std::endl;
    
    delete x;
    return 0;
}