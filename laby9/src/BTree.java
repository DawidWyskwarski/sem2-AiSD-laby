import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class BTree<T>{

    private class Node{

        private ArrayList<Node> children;
        private ArrayList<T> keys;
        
        private int numberOfKeys;
        private int numberOfKids;
        private int maxKeys;
        private int maxChildren; 


        @SuppressWarnings("unchecked")
        public Node(int t){
            
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.numberOfKeys = 0;
            this.numberOfKids = 0;
            this.maxChildren = 2*t;
            this.maxKeys = 2*t - 1;
        }

        public T getKey(int index){
            return keys.get(index);
        }
        public void setKey(int index, T value){
            keys.set(index, value);
        }
        public void setNumberOfKeys(int numberOfKeys) {
            this.numberOfKeys = numberOfKeys;
        }
        public void setNumberOfKids(int numberOfKids) {
            this.numberOfKids = numberOfKids;
        }

        public Node getChild(int index){
            return children.get(index);
        }
        public void setChild(int index, Node child){
            children.set(index, child);
        }
        
        public int getNumberOfKeys() {
            return numberOfKeys;
        }
        public int getNumberOfKids() {
            return numberOfKids;
        }
    
        public boolean isLeaf(){
            return numberOfKids == 0;
        }
        public boolean isFull(){
            return numberOfKids == keys.size();
        }
        
        public void addKey(T value,int index){
            keys.add(index, value);
            numberOfKeys++;
        }
        public void addChild(Node node,int index){
            children.add(index, node);
            numberOfKids++;
        }
    }

    private int t;
    private Comparator<T> comp;
    private Node root;

    public BTree(Comparator<T> comp,int t){
        if(t<=2){
            throw new InvalidParameterException("The value of t needs to be higher or equal to 2");
        }
        
        this.comp = comp;
        this.t = t;
        this.root = new Node(t);
    }

    public Node Search(T value){
        return Search(value,root);
    }
    private Node Search(T value, Node node){
       
        if(node == null){
            return null;
        } 
        
        int index = BinarySearch(node, value);

        if(comp.compare(value, node.getKey(index)) == 0){
            return node;
        }

        return Search(value,node.getChild(index));
    }

    public boolean Add(T value){
        
        if(value == null){
            throw new InvalidParameterException();
        }

        Stack<Node> history = new Stack<>();
        Node node = root;

        while(!node.isLeaf()){

            int index = BinarySearch(node, value);
            
            if(node.getChild(index) == value){
                return true;
            }

            history.push(node);    
            node = node.getChild(index);
        }

        if(node.isFull()){
            return false;
        }

        int index = BinarySearch(node, value);
        node.addKey(value, index);

        if(node.isFull()){
            if(node.equals(root)){
                DivideRoot();
            }
            else{
                DivideNode(history, node);
                // currently under construcions 
                // ~last updated in 2012~               
            }
        }

        return true;
    }

    private void DivideNode(Stack<Node> history, Node node){

    }

    private void DivideRoot(){
        
        Node left = new Node(t);
        Node right = new Node(t);

        for(int i=0;i<t-1;i++){
            left.addKey(root.getKey(i),i); 
            left.addChild(root.getChild(i), i);
            //left.setKey(i,root.getKey(i));
            //left.setChild(i, root.getChild(i));
        }

        for(int i=0;i<t-1;i++){
            right.setKey(i, root.getKey(i+t));
            right.setChild(i, root.getChild(i+t));
        }

        root.setKey(0, root.getKey(t-1));
        root.setChild(0,left);
        root.setChild(1,right);

        for(int i=1;i<2*t-1;i++){
            root.setKey(i, null);
            root.setChild(i+1, null);
        }
    }

    private int BinarySearch(Node node, T element){
        int left = 0;
        int right = node.getNumberOfKids()-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(comp.compare(node.getKey(mid), element) == 0){
                return mid;
            }

            if(comp.compare(node.getKey(mid), element) > 0){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }
}