#include <iostream>
#include <vector>

using namespace std;

class Stack
{
private:
    vector<int> data = vector<int>(200);
    int pointer = 0;

public:
    int pop(){return data[--pointer];};
    void push(int value){data[pointer++] = value;};
};

int main()
{
    string current;
    Stack* stack = new Stack();
    while (cin >> current)
    {
        if(current[0] == '+')
        {
            stack->push(stack->pop() + stack->pop());
        }
        else if(current[0] == '-')
        {
            int a = stack->pop();
            int b = stack->pop();
            stack->push(b - a);
        }
        else if(current[0] == '*')
        {
            stack->push(stack->pop() * stack->pop());
        }
        else
        {
            stack->push(atoi(current.c_str()));
        }
    }

    cout << stack->pop() << endl;
}
