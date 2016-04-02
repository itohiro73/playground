package jp.itohiro.playground.datamodel;

public class Stack<T> {
    private Object[] array;
    private int pointer;
    
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    
    public Stack(){
        array = new Object[DEFAULT_INITIAL_CAPACITY];
        pointer = 0;
    }
    
    public void push(T t) {
        array[pointer++] = t;
    }
    
    @SuppressWarnings("unchecked")
    public T pop() {
        return (T)array[--pointer];
    }
}
