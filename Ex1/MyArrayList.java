package ForGit.Ex1;

import java.util.Arrays;
public class MyArrayList <T>{
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
    public T get(int index){
        return (T) array[index];
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
