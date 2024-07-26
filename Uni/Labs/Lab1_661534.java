package Labs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import solutions.pack1.*;
public class Lab1_661534 {
    public static void main(String[] args){
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }
    public static void task1() {
        System.out.println("--task1---");
        ArrayList<String> lis1a = new ArrayList<>(Arrays.asList("Lily","Daisy"));
        ArrayList<String> lis1b = new ArrayList<>(Arrays.asList("Tulip","Daisy"));
        ArrayList<String> lis1c = new ArrayList<>();
        
        /* your code */
        lis1c.addAll(lis1a);
        lis1c.addAll(lis1b);

        System.out.println(lis1c);  
        // System.out.println(lis1a);
    }

    public static void task2(){
        System.out.println("--task2---");
        ArrayList<StringBuilder> lis1a = new ArrayList<>(Arrays.asList(new StringBuilder("Lily"), new StringBuilder( "Daisy")));
        ArrayList<StringBuilder> lis1b = new ArrayList<>(lis1a);
        lis1b.add(new StringBuilder("30"));        
        System.out.println(lis1b); 
        System.out.println(lis1a);  // Original data seems not affected
        StringBuilder sb = lis1a.get(0);
        sb.append("mySuffix");
        // Does lis2b.get(0) object change? Or it is not affected. Check it yourself.
        // complete the task by display "shallow copy" if lis2b first element is affected.
        /* your code */
        System.out.println(sb);
        System.out.println(lis1b);
        System.out.println(lis1a);
        if(lis1b.get(0).toString().equals(sb.toString())){
            System.out.println("Shallow copy");
        }else{
            System.out.println("Deep copy");
        }
    }
    public static void task3(){
        System.out.println("--task3---");
        List<String> lis3 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        /* your code */
        if (lis3.size() > 1) {
            // Remove all elements except the first one
            lis3.subList(1, lis3.size()).clear();
        }
        System.out.println(lis3);
    }
    public static void task4() { // show unique elements
        System.out.println("--task4---");
        ArrayList<String> lis1 = new ArrayList<>(Arrays.asList("Lily","Daisy","Tulip","Daisy"));
        List<String> lis4a = Arrays.asList("Lily","Daisy","Tulip","Daisy");
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (String ele : flowers) {
            System.out.print(ele + " ");
        }
        System.out.println();
        ArrayList<Dog_661534> lis4b = new ArrayList<>(Arrays.asList(new Dog_661534(Breed_661534.pomeranian,1200), new Dog_661534(Breed_661534.beagle, 2300), new Dog_661534(Breed_661534.jack, 1440), new Dog_661534(Breed_661534.beagle,2300)));
        HashSet<Dog_661534> dogs = new HashSet<>(lis4b);
        for (Dog_661534 ele : dogs) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void task5(){
        System.out.println("--task5---");
        ArrayList<Dog_661534> lis5 = new ArrayList<>(Arrays.asList(
        new Dog_661534(Breed_661534.pomeranian,1200),
        new Dog_661534(Breed_661534.beagle, 2300),
        new Dog_661534(Breed_661534.jack, 1440),
        new Dog_661534(Breed_661534.beagle,2300)));
        HashMap<Breed_661534,Integer> map = new HashMap<>();
        /* your code */
        
        for(Dog_661534 dog : lis5){
            Breed_661534 breed = dog.breed;
            if(map.containsKey(breed)){
                map.put(breed, map.get(breed) + 1);
            }else{
                map.put(breed,1);
            }
        }
        for (Entry<Breed_661534, Integer> ele : map.entrySet()) {
            System.out.println(ele.getKey()
            + "\t" + ele.getValue());
        }
    }

    public static void task6() {
        System.out.println("âtask6---");
        System.out.print("The number of unique element is ");
        ArrayList<Dog_661534> lis6 = new ArrayList<>(Arrays.asList(
        new Dog_661534(Breed_661534.pomeranian,1200),
        new Dog_661534(Breed_661534.beagle, 2300),
        new Dog_661534(Breed_661534.jack, 1440),
        new Dog_661534(Breed_661534.beagle,2300)));
        /* your code */
        HashSet<Breed_661534> unique = new HashSet<>();
        for(Dog_661534 dog : lis6){
            unique.add(dog.breed);
        }
        System.out.println(unique.size());
    }

    static int N = 10_000;
    static Integer [] arr = new Integer [N];
    static int num_iter = 100_000 * 10;
    static ArrayList<Integer> lis = new ArrayList<>();
    static LinkedList<Integer> llis;
    static {
        for (int i = 0; i < N; i++) {
        lis.add(i);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);
    }
    static void demo_arrayList(int idx) {
        int value;
        long start = System.currentTimeMillis();
        for (int iter = 0; iter < num_iter; iter++) {
        value = lis.get(idx);
        }
        long time = (System.currentTimeMillis() - start);
        System.out.println("ArrayList \ttakes " + time);
    }
    static void demo_linkedList(int idx) {
    /* your code */
        int value;
        long start = System.currentTimeMillis();
        for (int iter = 0; iter < num_iter; iter++) {
        value = llis.get(idx);
        }
        long time = (System.currentTimeMillis() - start);
        System.out.println("LinkedList \ttakes " + time);
    }
    static void demo_array(int idx) {
    /* your code */
        int value;
        long start = System.currentTimeMillis();
        for (int iter = 0; iter < num_iter; iter++) {
        value = arr[idx];
        }
        long time = (System.currentTimeMillis() - start);
        System.out.println("Array \ttakes " + time);
    }
    static void task7() {
    // accessing 0, 25%, 50% and 75%
    for (int index = 0; index < arr.length;index += arr.length/4) {
        System.out.println("Index is at " + index);
        demo_arrayList(index);
        demo_linkedList(index);
        demo_array(index);
    }
    }
}