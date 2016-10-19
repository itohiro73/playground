#include <iostream>
#include <vector>

using namespace std;

int main(){
    int length;
    cin >> length;

    vector<int> vector(length);

    for (int i = 0; i < length; i++)
    {
        cin >> vector[i];
    }
    for (int i = 0; i < length; i++)
    {
        int j = i-1;
        int intermediate = vector[i];
        while(j >= 0 && vector[j] > intermediate)
        {
            vector[j+1] = vector[j];
            vector[j] = intermediate;
            j--;
        }
        cout << vector[0];
        for (int k = 1; k < length; k++)
        {
            cout << ' ' << vector[k];
        }
        cout << endl;
    }
}