package solutions.pack3;

public class MyArray_66011090 extends MyArrayBasic_66011090{
    public MyArray_66011090(){
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }

    public MyArray_66011090(int max){
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public void add(int d){
        if(!isFull()){
            data[size++] = d;
        } else {
            expandByK(2);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int[] expandByK(int k){
        int[] newData = new int[MAX_SIZE*k];
        System.arraycopy(data, 0, newData, 0, size);
        MAX_SIZE *= k;
        data = newData;
        return data;
    }

    public int[] expand(){
        return expandByK(2);
    }
}
