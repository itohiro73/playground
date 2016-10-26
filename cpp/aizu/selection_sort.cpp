#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int length, count = 0;
    cin >> length;

    vector<int> vector(length);

    for (int i = 0; i < length; i++)
    {
        cin >> vector[i];
    }
    for (int i = 0; i < length; i++)
    {
        int mini = i;
        for (int j = i; j < length; j++)
        {
            if(vector[j] < vector[mini])
            {
                mini = j;
            }
        }
        int temp = vector[mini];
        vector[mini] = vector[i];
        vector[i] = temp;
        if(mini!=i) count++;
    }
    cout << vector[0];
    for (int i = 1; i < length; i++)
    {
        cout << ' '<< vector[i];
    }
    cout << endl << count << endl;
}