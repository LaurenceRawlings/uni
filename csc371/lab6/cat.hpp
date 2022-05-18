#ifndef CAT_H_
#define CAT_H_
#include <string>
#include <sstream>

class Cat
{
private:
    std::string name;
    unsigned int lives;

public:
    Cat();
    Cat(std::string name);
    Cat(std::string name, unsigned int lives);

    std::string get_name() const;
    unsigned int get_lives() const;

    void set_name(std::string const name);
    void set_lives(unsigned int const lives);

    friend std::ostream &operator<<(std::ostream &os, const Cat &cat);
    friend bool operator==(const Cat& lhs, const Cat& rhs);
    friend bool operator<(const Cat &lhs, const Cat &rhs);
};

namespace std
{
    template <>
    struct hash<Cat>
    {
        size_t operator()(const Cat &obj) const
        {
            std::stringstream ss;
            ss << obj;
            return std::hash<std::string>{}(ss.str());
        }
    };
}

#endif // CAT_H_