#include <iostream>
#include "Vector.h"

using namespace std;

template <typename T>
T min (T a, T b)
{
    return (a < b) ? a : b;
}

template <typename T1, typename T2>
auto min_decltype (T1 a, T2 b) -> decltype((a < b) ? a : b)
{
    return (a < b) ? a : b;
};

int main()
{
//    int x;
//    double y;
//
//    x = min<int>(10, 20);
//    y = min<double>(3.79, 4.23);
//
//
//    std::cout << "x: " << x << std::endl;
//    std::cout << "y: " << y << std::endl;
//    std::cout << "mixed: " << min_decltype(4.23, 10) << std::endl;

    Vector v;
    v.add(new Integer(43));
    v.add(new Integer(12));
    for (int i=0; i<v.size(); ++i)
    {
        Integer* ptr = (Integer*) v.at(i);
        cout << ptr->value() << endl;
    }
}

