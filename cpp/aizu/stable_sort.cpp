#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int length, count = 0;
    cin >> length;

    vector<string> vector(length);

    for (int i = 0; i < length; i++)
    {
        cin >> vector[i];
    }

    //sort logic

    cout << vector[0];
    for (int i = 1; i < length; i++)
    {
        cout << ' '<< vector[i];
    }
    cout << endl << count << endl;
}