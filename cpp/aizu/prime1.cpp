#include <iostream>

using namespace std;

bool isPrime(int x);

int main()
{
    int number, count=0;
    cin >> number;
    for(int i = 0; i < number; i++)
    {
        int current;
        cin >> current;
        if(isPrime(current)) count++;
    }
    cout << count << endl;
}

bool isPrime(int x)
{
    if(x < 2) return false;
    if(x == 2) return true;
    for(int i = 2; i * i <= x; i++)
    {
        if(x % i == 0) return false;
    }
    return true;
}