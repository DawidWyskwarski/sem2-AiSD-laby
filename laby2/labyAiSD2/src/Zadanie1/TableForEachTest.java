package Zadanie1;

public class TableForEachTest {
    public static void main(String[] args) {
        
        Table<Integer> a = new Table<>(3);
        for(int i=0;i<a.size();i++){
            a.set(i,i+1);
        }

        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("======");

        Table<String> b = new Table<>(4);
        b.set(0,"jeden");
        b.set(1,"dwa");
        b.set(2,"trzy");
        b.set(3,"cztery");

        for (String string : b) {
            System.out.println(string);
        }
        System.out.println("======");

        
        Table<Integer> c = new Table<>(0);

        for (Integer integer : c) {
            System.out.println(integer);
        }
        System.out.println("======");

        
        Table<Integer> d = null;
        
        for (Integer integer : d) {
            System.out.println(integer);
        }
        
        System.out.println("======");

    }
}
