#include <iostream>
#include "Shape.hpp"

int main(int argc , char *argv[]) {
    Shape **xs = new Shape*[10];

    xs[0] = new Circle(1, 2, 3);
    xs[1] = new Rectangle(4, 5, 6, 7);
    xs[2] = new Triangle(8, 9, 10, 11, 12, 13);
    xs[3] = new Circle(14, 15, 16);
    xs[4] = new Rectangle(17, 18, 19, 20);
    xs[5] = new Triangle(21, 22, 23, 24, 25, 26);
    xs[6] = new Circle(27, 28, 29);
    xs[7] = new Rectangle(30, 31, 32, 33);
    xs[8] = new Triangle(34, 35, 36, 37, 38, 39);
    xs[9] = new Circle(40, 41, 42);

    for (int i = 0; i < 10; i++) {
        std::cout << xs[i]->to_string() << std::endl;
    }

    for (int i = 0; i < 10; i++) {
        xs[i]->centre_at(i, i);
        std::cout << xs[i]->to_string() << std::endl;
        delete xs[i];
    }

    delete [] xs;
    return 0;
}