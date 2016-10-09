#include <iostream>

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
    int x;
    double y;

    x = min<int>(10, 20);
    y = min<double>(3.79, 4.23);


    std::cout << "x: " << x << std::endl;
    std::cout << "y: " << y << std::endl;
    std::cout << "mixed: " << min_decltype(4.23, 10) << std::endl;
}

