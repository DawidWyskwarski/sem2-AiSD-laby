package same;

public class testLista {
    public static void main(String[] args) throws Exception {
        
        TwoWayLinkedList<String> test = new TwoWayLinkedList<>();
        
        System.out.println("isEmpty test: ");
        System.out.println(test.isEmpty());
        
        //add test
        test.add("a");
        test.add("b");
        test.add("c");
        test.add(0, "x");
        test.add(3,"z");
        test.add("aaa");
        test.add(0,"dwa");

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("Size " + test.size());

        test.remove("dwa");
        test.remove("aaa");
        test.remove(0);
        test.remove(2);

        System.out.println("after removing");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("Size: " + test.size());

        test.clear();
        test.add("a");
        test.add(0, "aa");
        
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }

        test.set(0, "b");
        
        System.out.println("======");

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
    }

}
