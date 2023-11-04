package ForGit.Ex4;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] array = new Object[10];

    public void push(Object value){
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
    public void remove(int index){
        for (int i = index+1; i<array.length; i++){
            array[i-1] = array[i];
            array[i] = null;
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
        if (size()==0) {
            return null;
        }
        return (T) array[size() - 1];
    }
    public T pop(){
        T elem = peek();
        if (elem != null) {
            array[size() - 1] = null;
        }
        return elem;
    }


    @Override
    public String toString() {
        //cleaning array
        int count = 0;
        for (Object elem : array){
            if (elem != null){
                count++;
            }
        }
        array = Arrays.copyOf(array, count);
        //reversing array
        Object[] arr = new Object[array.length];
        int index = 0;
        for (int i = array.length-1; i >= 0;i--){
            arr[index] = array[i];
            index++;
        }
        return "MyQueue{" +
                "array=" + Arrays.toString(arr) +
                '}';
    }
}
