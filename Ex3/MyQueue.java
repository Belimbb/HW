package ForGit.Ex3;

import java.util.Arrays;

public class MyQueue<T> {
    private Object[] array = new Object[10];

    public void add(T value){
        if (size()+1>array.length){
            array = Arrays.copyOf(array, (int) (array.length*1.5));
        }
        for (int i = 0; i<array.length; i++){
            if (array[i]==null) {
                array[i] = value;
                break;
            }
        }
    }
    public void clear(){
        Arrays.fill(array, null);
    }
    public int size(){
        int count = 0;
        for (Object elem : array){
            if (elem != null){
                count++;
            }
        }
        return count;
    }
    public T peek(){
        return (T) array[0];
    }
    public T poll(){
        T elem = peek();
        for (int i = 1; i<array.length; i++){
            array[i-1] = array[i];
            array[i] = null;
        }
        return elem;
    }

    @Override
    public String toString() {
        int count = 0;
        for (Object elem : array){
            if (elem != null){
                count++;
            }
        }
        array = Arrays.copyOf(array, count);
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
