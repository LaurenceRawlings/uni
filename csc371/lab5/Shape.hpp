#ifndef SHAPE_H_
#define SHAPE_H_

#include <string>

class Shape
{
public:
    Shape();
    virtual ~Shape();
    virtual std::string to_string() const = 0;
    virtual void centre_at(double x, double y) = 0;
};

class Circle : public Shape {
private:
    double x;
    double y;
    double r;

public:
    Circle(double x, double y, double r);
    virtual ~Circle();
    virtual std::string to_string() const;
    virtual void centre_at(double x, double y);
};

class Rectangle : public Shape {
private:
    double x0;
    double y0;
    double x1;
    double y1;

public:
    Rectangle(double x0, double y0, double x1, double y1);
    virtual ~Rectangle();
    virtual std::string to_string() const;
    virtual void centre_at(double x, double y);
    double width() const;
    double height() const;
};

class Triangle : public Shape {
private:
    double x0;
    double y0;
    double x1;
    double y1;
    double x2;
    double y2;

public:
    Triangle(double x0, double y0, double x1, double y1, double x2, double y2);
    virtual ~Triangle();
    virtual std::string to_string() const;
    virtual void centre_at(double x, double y);
    double side(double x0, double y0, double x1, double y1) const;
};

#endif // SHAPE_H_