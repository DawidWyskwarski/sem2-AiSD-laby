import java.util.ArrayList;
import java.util.Iterator;

public class mod2 {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Number> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        Iterator<Number> iter1 = a.iterator();
        AccumulatingIterator Acc1 = new AccumulatingIterator(iter1);

        while(Acc1.hasNext()){
            System.out.println(Acc1.next());
        }
        System.out.println("========");


        ArrayList<Number> b = new ArrayList<>();
        b.add(10.33);
        b.add(2.47);
        b.add(50);
        b.add(3.0001);
        b.add(0);
        Iterator<Number> iter2 = b.iterator();
        AccumulatingIterator Acc2 = new AccumulatingIterator(iter2);

        while(Acc2.hasNext()){
            System.out.println(Acc2.next());
        }
        System.out.println("========");

        
        ArrayList<Number> c = new ArrayList<>();
        
        Iterator<Number> iter3 = c.iterator();
        AccumulatingIterator Acc3 = new AccumulatingIterator(iter3);

        while(Acc3.hasNext()){
            System.out.println(Acc3.next());
        }
        System.out.println("========");

        
        Iterator<Number> iter4 = null;
        AccumulatingIterator Acc4 = new AccumulatingIterator(iter4);

        while(Acc4.hasNext()){
            System.out.println(Acc4.next());
        }
        

        
    }
}
