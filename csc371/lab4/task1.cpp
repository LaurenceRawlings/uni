#include <iostream>
#include "cat.h"

int main(int argc, char* argv[]) {
    Cat a("Garfield");
    
    std::cout << a.get_name() << " has "
              << a.get_lives() << " lives." << std::endl;
              
    Cat b("Mog" , 10);
    std::cout << b.get_name() << " has "
              << b.get_lives() << " lives." << std::endl;
              
    return 0;
}