#include<iostream>
#include<array>
using namespace std;

int main(){
    array<int, 10> height;

    for (int i = 0; i < 10; ++i)
    {
        cin >> height[i];
        int j = i-1;
        int intermediate = height[i];
        while(j >= 0 && height[j] < intermediate)
        {
            height[j+1] = height[j];
            height[j] = intermediate;
            j--;
        }
    }
    cout << height[0] << endl;
    cout << height[1] << endl;
    cout << height[2] << endl;
}