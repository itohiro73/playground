#include <iostream>
#include <jmorecfg.h>

using namespace std;

boolean isPrime(int x);

int main()
{
    int a, b;
    cin >> a >> b;
    cout << isPrime(a) << endl;
}

boolean isPrime(int a)
{
    int x, y;
    if (a > b) x = a, y = b;
    else y = a, x = b;
    if(y != 0 && x / y > 0)
    {
        return isPrime(y);
    }
    else
    {
        return x;
    }
}