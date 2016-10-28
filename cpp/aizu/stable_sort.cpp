#include <iostream>
#include <vector>

using namespace std;

class Card
{
private:
    string name_;
    int value_;

public:
    Card(string card)
    {
        name_ = card;
        value_ = stoi(card.substr(1, 1));
    };

    string name(){return name_;};
    int value(){return value_;};
};

void bubbleSort(vector<Card *> &cards);

void shellSort(vector<Card *> &cards);

int main()
{
    int length, count = 0;
    cin >> length;

    vector<Card*> cards(length);

    for (int i = 0; i < length; i++)
    {
        string card;
        cin >> card;
        cards[i] = new Card(card);
    }

    bubbleSort(cards);
    shellSort(cards);
}

void bubbleSort(vector<Card *> &cards)
{
    for(int i = 0; i < cards.size(); i++)
    {
        for(int j = cards.size() - 1; j > i; j--)
        {
            if(cards[j-1]->value() > cards[j]->value())
            {
                Card* temp = cards[j-1];
                cards[j-1] = cards[j];
                cards[j] = temp;
            }
        }
    }
    cout << cards[0]->name();
    for(int i = 1; i < cards.size(); i++)
    {
        cout << ' ' << cards[i]->name();
    }
    cout << endl << "Stable" << endl;
}

void shellSort(vector<Card *> &cards)
{

}
