#include <iostream>

using namespace std;

int gcd(int x, int y);

int main()
{
    int a, b;
    cin >> a >> b;
    cout << gcd(a, b) << endl;
}

int gcd(int a, int b)
{
    int x, y;
    if (a > b) x = a, y = b;
    else y = a, x = b;
    if(y != 0 && x / y > 0)
    {
        return gcd(y, x % y);
    }
    else
    {
        return x;
    }
}