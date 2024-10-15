import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        
        BST<Integer> test = new BST<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });

        /*test.add(7);
        test.add(6);
        test.add(10);
        test.add(3);
        test.add(8);
        test.add(12);
        test.add(4);
        test.add(9);
        test.add(5);

        System.out.println(test.findNode(6));

        System.out.println(test.findMax());
        System.out.println(test.findMin());

        System.out.println(test.findSuccesor(8));

        IntegerToStringExec exec = new IntegerToStringExec();
        test.inOrderWalk(exec);
        
        System.out.println(exec.getResult());

        test.remove(7);

        exec.lineNoMore();
        test.inOrderWalk(exec);
        
        System.out.println(exec.getResult());

        test.clear(); */

        /*test.add(9);
        test.add(8);
        test.add(7);
        test.add(6);
        test.add(5);
        test.add(4);
        test.add(3);
        test.add(2);
        test.add(1);

        System.out.println(test.findMax());
        System.out.println(test.findMin());

        IntegerToStringExec exec = new IntegerToStringExec();
        test.inOrderWalk(exec);
        System.out.println(exec.getResult());*/


        /*test.add(52);
        test.add(79);
        test.add(3);
        test.add(21);
        test.add(92);
        test.add(54);
        test.add(13);
        test.add(71);

        System.out.println(test.findMax());
        System.out.println(test.findMin());

        //test.widePrint();

        test.remove(54);

        test.widePrint();*/

        test.add(10);
        test.add(7);
        test.add(21);
        test.add(6);
        test.add(8);
        test.add(9);
        test.add(11);
        test.add(27);
        test.add(25);

        /*test.add(15);
        test.add(4);
        test.add(17);
        test.add(2);
        test.add(1);
        test.add(3);
        test.add(14);
        test.add(10);
        test.add(12);
        test.add(11);
        test.add(13);
        test.add(19);
        test.add(20);

        /*test.add(10);
        test.add(5);
        test.add(15);
        test.add(2);
        test.add(7);
        test.add(12);
        test.add(17); */
        

        BST<Integer> sub = test.mostImbalanceSubTree();

        sub.widePrint();
    }
}
