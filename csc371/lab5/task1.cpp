#include <iostream>
#include "Shape.hpp"

int main(int argc , char *argv[]) {
    Shape *x = new Circle(0, 0, 1); // x, y, r
    
    std::cout << x->to_string() << std::endl;
    x->centre_at(2, 3);
    
    std::cout << x->to_string() << std::endl;
    
    delete x;
    return 0;
}