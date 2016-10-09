#include <iostream>

int main() {
    while(true)
    {
        std::cout << "Calculator: ";
        int lval = 0;
        int rval;
        char op;
        std::cin >> lval;
        if(!std::cin && !isdigit(lval))
        {
            throw std::runtime_error("Invalid first operand");
        }

        while(std::cin >> op)
        {
            if(op != '+' && op != '-' && op != '*' && op != '/')
            {
                std::cout << "Result: " << lval << std::endl;
                return 0;
            }
            std::cin >> rval;
            if(!std::cin && !isdigit(rval))
            {
                throw std::runtime_error("Invalid another operand");
            }
            switch(op)
            {
                case '+':
                    lval += rval;
                    break;
                case '-':
                    lval -= rval;
                    break;
                case '*':
                    lval *= rval;
                    break;
                case '/':
                    lval /= rval;
                    break;
                default:
                    std::cout << "Result: " << lval << std::endl;
                    return 0;
            }
        }

        std::cout << "bad expression";
        return 1;
    }
}