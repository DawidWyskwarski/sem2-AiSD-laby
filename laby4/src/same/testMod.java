package same;
public class testMod { 

    public static void main(String[] args) throws Exception {
        
        TwoWayLinkedList<Integer> test = new TwoWayLinkedList<>();
    
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

        test.rotateLeft(3);
        System.out.println("3:");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

        
        test.rotateLeft(4);
        System.out.println("4:");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");



        test.rotateLeft(14);

        System.out.println("14: ");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

        test.add(8);

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

        System.out.println("5:");
        test.rotateLeft(5);

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");


        test.add(null);

        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");


        //obrot z nullem
        test.rotateLeft(1);
        System.out.println("1:");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");


        test.rotateLeft(0);
        System.out.println("0:");
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

        

        test.clear();
        System.out.println("pusto: ");
        test.rotateLeft(7);
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");


        test.add(1);

        System.out.println("jeden element 8: ");
        test.rotateLeft(8);
        for(int i=0;i<test.size();i++){
            System.out.println(test.get(i));
        }
        System.out.println("======");

    }
}
