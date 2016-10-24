#include <iostream>
#include <climits>

using namespace std;

int main()
{
    int n, max=INT_MIN, min;
    cin >> n;
    cin >> min;
    for(int i = 1; i < n; i++)
    {
        int current, potentialMax;
        cin >> current;
        potentialMax = current - min;
        if(max < potentialMax) max = potentialMax;
        if(min > current) min = current;
    }
    cout << max << endl;
}
