package Zadanie2;

import java.rmi.NoSuchObjectException;

public class ShiftIteratorTest {

    public static void main(String[] args) throws NoSuchObjectException {
        
        Integer[] a ={1,2,3};
        
        Iter<Integer> iter1 = new Iter<Integer>(a);
        ShiftIterator<Integer> Shift1 = new ShiftIterator<Integer>(iter1);

        while(Shift1.hasNext()){
            System.out.println(Shift1.next());
        }
        System.out.println("======");


        String[] b ={"a"};
        
        Iter<String> iter2 = new Iter<String>(b);
        ShiftIterator<String> Shift2 = new ShiftIterator<String>(iter2);

        while(Shift2.hasNext()){
            System.out.println(Shift2.next());
        }
        System.out.println("======");


        String[] c ={"a","b","c","d","e","f"};
        
        Iter<String> iter3 = new Iter<String>(c);
        ShiftIterator<String> Shift3 = new ShiftIterator<String>(iter3);

        while(Shift3.hasNext()){
            System.out.println(Shift3.next());
        }
        System.out.println("======");


        String[] d ={};
        
        Iter<String> iter4 = new Iter<String>(d);
        ShiftIterator<String> Shift4 = new ShiftIterator<String>(iter4);

        while(Shift4.hasNext()){
            System.out.println(Shift4.next());
        }
        System.out.println("======");

        
        /*String[] e = null;
        
        Iter<String> iter5 = new Iter<String>(e);
        ShiftIterator<String> Shift5 = new ShiftIterator<String>(iter5);

        while(Shift5.hasNext()){
            System.out.println(Shift5.next());
        }
        System.out.println("======");
        */
        
        Iter<Integer> iter6 = null;
        ShiftIterator<Integer> Shift6 = new ShiftIterator<>(iter6);

        while(Shift6.hasNext()){
            System.out.println(Shift6.next());
        }
        System.out.println("======");


    }

}
