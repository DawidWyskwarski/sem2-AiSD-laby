package Zadanie1;

import java.rmi.NoSuchObjectException;

public class TableIteratorTest {
    public static void main(String[] args) throws NoSuchObjectException {
        
        Integer[] a = {1,2,3,4};
        TableIterator<Integer> test1 = new TableIterator<Integer>(a);

        while(test1.hasNext()){
            System.out.println(test1.next());
        }
        System.out.println("======");


        String[] b = {"jeden", "dwa", "trzy", "cztery","pięć"};
        TableIterator<String> test2 = new TableIterator<String>(b);

        while(test2.hasNext()){
            System.out.println(test2.next());
        }
        System.out.println("======");
        

        Integer[] c = {};
        TableIterator<Integer> test3 = new TableIterator<Integer>(c);

        while(test3.hasNext()){
            System.out.println(test3.next());
        }
        System.out.println("======");

        
        Integer[] d = null;
        TableIterator<Integer> test4 = new TableIterator<Integer>(d);

        while(test4.hasNext()){
            System.out.println(test4.next());
        }
        System.out.println("======");
    }
}
