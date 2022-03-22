package cmsc256;

import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T> {
    private T [] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack(){
        this(INITIAL_CAPACITY);
    }

    public ArrayBasedStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Array initial size error");
        }
       clear();
    }

    private T[] expandArray(){
        T [] twice = Arrays.copyOf(data,data.length* 2 );
        return twice;
    }
    private boolean isArrayFull(){
        if(topOfStack >= data.length - 1){
            return true;
        }
        return false;
    }


    @Override
    public void push(T newEntry) {
        if(isArrayFull()){
           data = expandArray();
        }
        topOfStack++;
        data[topOfStack] = newEntry;
    }

    @Override
    public T pop() {
       if(isEmpty()){
           throw new EmptyStackException();
       }
       T temp = data[topOfStack];
       data[topOfStack] = null;
       topOfStack--;
       return temp;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T removed = data[topOfStack];
        return removed;
    }

    @Override
    public boolean isEmpty() {
        if(topOfStack < 0 ){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[INITIAL_CAPACITY];
            data = tempStack;
            topOfStack = -1;

    }
}
