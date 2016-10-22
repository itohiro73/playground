//
// Created by 伊藤博志 on 10/22/16.
//

#ifndef CPP_VECTOR_H
#define CPP_VECTOR_H

class Object
{
public:
    virtual ~Object(){}
};

class Vector : public Object
{
    Object** data_;
    int capacity_;
    int size_;

public:
    Vector() : data_(0), capacity_(0), size_(0){}
    ~Vector()
    {
        for (int i = 0; i < size_; ++i)
        {
            delete data_[i];
        }
        delete[] data_;
    }

    void add(Object* item)
    {
        if (size_ == capacity_)
        {
            capacity_ += 10;
            Object** tmp = new Object*[capacity_];
            for (int i = 0; i < size_; ++i)
            {
                tmp[i] = data_[i];
            }
            delete[] data_;
            data_ = tmp;
        }
        data_[size_++] = item;
    }

    Object* at(int index)
    {
        if (index < 0 || index >= size_)
        {
            return 0;
        }
        return data_[index];
    }

    int size() const {return size_;}
};

class Integer : public Object
{
    int value_;

public:
    Integer(int v) : value_(v) {}
    int value() const { return value_;}
};

#endif //CPP_VECTOR_H
