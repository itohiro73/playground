#ifndef CPP_STONE_EXCEPTION_H
#define CPP_STONE_EXCEPTION_H

#include <stdexcept>
using namespace std;

class stone_exception : runtime_error
{
public:
    stone_exception(string error) : runtime_error(error){ }
};


#endif //CPP_STONE_EXCEPTION_H
