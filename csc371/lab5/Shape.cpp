#include <string>
#include <sstream>
#include <cstdlib>
#include <cmath>
#include "Shape.hpp"


Shape::Shape() {}
Shape::~Shape() {}

Circle::Circle(double x, double y, double r)
    : x(x), y(y), r(r) {}

Circle::~Circle() {}

std::string Circle::to_string() const
{
    std::stringstream sstr;
    sstr << "Circle centred at (" << this->x << ", " << this->y 
        << ") with radius " << this->r << "...";
    return sstr.str();
}

void Circle::centre_at(double x, double y)
{
    this->x = x;
    this->y = y;
}

Rectangle::Rectangle(double x0, double y0, double x1, double y1)
    : x0(x0), y0(y0), x1(x1), y1(y1) {}

Rectangle::~Rectangle() {}

std::string Rectangle::to_string() const
{
    std::stringstream sstr;
    sstr << "Rectangle at [(" << this->x0 << ", " << this->y0 << "), (" << this->x1
        << ", " << this->y1 << ")] with width " << this->width() << ", height " << this->height() << "...";
    return sstr.str();
}

void Rectangle::centre_at(double x, double y)
{
    double half_width = width() / 2;
    double half_height = height() / 2;

    this->x0 = x - half_width;
    this->y0 = y + half_height;
    this->x1 = x + half_width;
    this->y1 = y - half_height;
}

double Rectangle::width() const 
{
    return abs(this->x1 - this->x0);
}

double Rectangle::height() const 
{
    return abs(this->y0 - this->y1);
}

Triangle::Triangle(double x0, double y0, double x1, double y1, double x2, double y2)
    : x0(x0), y0(y0), x1(x1), y1(y1), x2(x2), y2(y2) {}

Triangle::~Triangle() {}

std::string Triangle::to_string() const
{
    std::stringstream sstr;
    sstr << "Triangle at [(" << this->x0 << ", " << this->y0 << "), (" << this->x1
        << ", " << this->y1 << "), (" << this->x2 << ", " << this->y2 << ")] with side lengths "
        << this->side(this->x0, this->y0, this->x1, this->y1) << ", "
        << this->side(this->x1, this->y1, this->x2, this->y2) << ", and "
        << this->side(this->x2, this->y2, this->x0, this->y0) << "...";
    return sstr.str();
}

void Triangle::centre_at(double x, double y)
{
    double move_x = ((this->x0 + this->x1 + this->x2) / 3) - x;
    double move_y = ((this->y0 + this->y1 + this->y2) / 3) - y;

    this->x0 += move_x;
    this->y0 += move_y;
    this->x1 += move_x;
    this->y1 += move_y;
    this->x2 += move_x;
    this->y2 += move_y;
}

double Triangle::side(double x0, double y0, double x1, double y1) const
{
    return std::pow(std::pow(x0 - x1, 2) + std::pow(y0 - y1, 2), 0.5);
}