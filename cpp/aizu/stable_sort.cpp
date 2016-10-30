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

    vector<Card*> bubble_cards(length);
    vector<Card*> selection_cards(length);

    for (int i = 0; i < length; i++)
    {
        string card;
        cin >> card;
        bubble_cards[i] = new Card(card);
        selection_cards[i] = new Card(card);
    }

    bubbleSort(bubble_cards);
    shellSort(selection_cards);
    for (int i = 0; i< bubble_cards.size(); i++)
    {
        if(bubble_cards[i]->name() != selection_cards[i]->name())
        {
            cout << "Not stable" << endl;
            return 0;
        }
    }
    cout << "Stable" << endl;
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
    for(int i = 0; i < cards.size(); i++)
    {
        int mini = i;
        for(int j = i; j < cards.size(); j++)
        {
            if (cards[j]->value() < cards[mini]->value())
            {
                mini = j;
            }
        }
        Card* temp;
        temp = cards[mini];
        cards[mini] = cards[i];
        cards[i] = temp;
    }
    cout << cards[0]->name();
    for(int i = 1; i < cards.size(); i++)
    {
        cout << ' ' << cards[i]->name();
    }
    cout << endl;
}
