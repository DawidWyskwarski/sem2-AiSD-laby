import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> list = new Stack<>();
        
        list.push(1);
        list.push(2);
        list.push(3);

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }
}
