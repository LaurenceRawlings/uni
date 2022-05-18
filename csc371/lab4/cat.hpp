#ifndef CAT_H_
#define CAT_H_
#include <string>

class Cat
{
private:
    std::string name;
    unsigned int lives;

public:
    Cat();
    Cat(std::string name);
    Cat(std::string name, unsigned int lives);
    ~Cat();

    std::string get_name() const;
    unsigned int get_lives() const;

    void set_name(std::string const name);
    void set_lives(unsigned int const lives);
};

#endif // CAT_H_