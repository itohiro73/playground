#include <iostream>

using namespace std;

int main()
{
    int n, max, min, previous, current;
    cin >> n;
    cin >> previous;
    cin >> current;
    min = previous;
    max = current;
    for(int i = 2; i < n; i++)
    {
        previous = current;
        cin >> current;
        if(current > max || previous == min) max = current;
        else if (current < min && i < n-1) min = current;
    }
    cout << max - min << endl;
}
