package solutions.pack3;

import java.util.Arrays;

public class MyArrayBasic_66011090 {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public  MyArrayBasic_66011090(){}

    public MyArrayBasic_66011090(int...a){
        MAX_SIZE = a.length;
        // data = new int[MAX_SIZE];
        // size = 0;

        // for (int i=0; i<MAX_SIZE;i++){
        //     data[i] = a[i];
        //     size++;
        // }
    }

    public void add(int d){
        data[size++] = d;
    }

    public void insert(int d, int index){
        // data[size++] = data[index];
        // data[index] = d;
        
        for (int i = size; i>index; i--){
            data[i] = data[i-1];
        }
        data[index] = d;
        size++;
        
        System.out.println(Arrays.toString(data));
    }

    public int find(int d){
        for (int i=0; i<size; i++){
            if (data[i] == d){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d){
        int a=0, b=size-1;
        while(a<=b){
            int m = (a+b)/2;
            if (data[m]==d) return m;
            if (d<data[m]) b = m-1;
            else a = m+1;
        }
        return -1;
    }

    public void delete(int index){
        if (size == 0){
            return;
        }
        for (int i=index; i<size-1; i++){
            data[i] = data[i+1];
        }
        size--;
    }

    @Override
    public String toString() {
        return "MyArrayBasic [data=" + Arrays.toString(data) + "]";
    }
}