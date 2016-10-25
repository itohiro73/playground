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
        for (int j = length - 1; j > 0; j--)
        {
            if(vector[j-1] > vector[j])
            {
                int temp = vector[j];
                vector[j] = vector[j-1];
                vector[j-1] = temp;
                count++;
            }
        }
    }
    cout << vector[0];
    for (int i = 1; i < length; i++)
    {
        cout << ' '<< vector[i];
    }
    cout << endl << count << endl;
}