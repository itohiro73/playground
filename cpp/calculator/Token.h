#ifndef CPP_TOKEN_H
#define CPP_TOKEN_H

#include <string>
#include "stone_exception.h"
using namespace std;

class Token
{
private:
    int lineNumber;

public:
    static const Token* EOF_;
    static const string EOL_;
    Token(int line)
    {
        lineNumber = line;
    }

    int getLineNumber()
    {
        return lineNumber;
    }

    bool isIdentifier()
    {
        return false;
    }

    bool isNumber()
    {
        return false;
    }

    bool isString()
    {
        return false;
    }

    int getNumber()
    {
        throw new stone_exception("not number token");
    }
};

const Token* Token::EOF_ = new Token(-1);
const string Token::EOL_ = "\n";

#endif //CPP_TOKEN_H
