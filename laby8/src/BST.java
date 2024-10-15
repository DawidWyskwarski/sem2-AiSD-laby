import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST<T> {
    
    private class Node{
        private T value;
        private Node left;
        private Node right;
        private int imbalans;

        public Node(T value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.imbalans = 0;
        }

        private int getImbalans() {
            return imbalans;
        }
        public T getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }

        private void setValue(T value) {
            this.value = value;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public void setImbalans(int imbalans) {
            this.imbalans = imbalans;
        }
    }

    private Node root;
    private int size;
    private Comparator<T> comp;

    public BST(Comparator<T> comp){
        this.comp = comp;
        this.root = null;
        this.size = 0;
    }

    public BST(Comparator<T> comp, Node root){
        this.comp = comp;
        this.root = root;
    }

    public int getSize() {
        return size;
    }
    
    public void clear(){
        root = null;
        size = 0;
    }

    public T findMin(){
        if(size == 0){
            throw new NoSuchElementException();
        }

        return findMin(root).getValue();
    }
    private Node findMin(Node node){

        if(node.getLeft() == null){
            return node;
        }

        return findMin(node.getLeft());
    }

    public T findMax(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        
        return findMax(root).getValue();
    }
    private Node findMax(Node node){

        if(node.getRight() == null){
            return node;
        }

        return findMax(node.getRight());
    }

    public Node findNode(T value){
        if(value == null){
            throw new InvalidParameterException();
        }
        
        if(size == 0){
            throw new NoSuchElementException();
        }

        return findNode(root,value);
    }
    private Node findNode(Node node,T value){
        
        if(node == null || comp.compare(node.getValue(),value) == 0){
            return node; 
        }

        if(comp.compare(node.getValue(), value) > 0){
            return findNode(node.getLeft(), value);
        }

        return findNode(node.getRight(), value);
    }

    public T findSuccesor(T value){

        return findSuccesorP(value).getValue();
    }
    private Node findSuccesorP(T value){
        
        if(value == null){
            throw new InvalidParameterException();
        }
        
        Node wantedNode = findNode(value);

        if(wantedNode == null){
            throw new NoSuchElementException();
        }
        if(wantedNode.getValue() == findMax()){
            throw new NoSuchElementException();
        }
        if(wantedNode.getRight() != null){
            return findMin(wantedNode.getRight());
        }

        Node cur = root;
        Node SuccNode = root;

        while(!cur.equals(wantedNode)){

            if(comp.compare(cur.getValue(),value) > 0){
                SuccNode = cur;
                cur = cur.getLeft();
            }
            else{
                cur = cur.getRight();
            }
        }

        return SuccNode;
    }

    public void add(T value){
        if(value == null){
            throw new InvalidParameterException();
        }

        Node newNode = new Node(value);

        if(size == 0){
            root = newNode;
            size++;
            return;
        }
        size++;
        
        Node cur = root; 
        Boolean stop = false;

        while(!stop){

            if(comp.compare(cur.getValue(), value) > 0){

                if(cur.getLeft() == null){
                    cur.setLeft(newNode);
                    stop = true;
                }
                else{
                    cur = cur.getLeft();
                }
            }
            else{

                if(cur.getRight() == null){
                    cur.setRight(newNode);
                    stop = true;
                }
                else{
                    cur = cur.getRight();
                }
            }   
        } 
    }        

    public void remove(T value){
        
        if(value == null){
            throw new InvalidParameterException();
        }

        Node wantedNode = findNode(value);

        if(wantedNode == null){
            throw new NoSuchElementException();
        }
        
        size--;

        if(wantedNode.getLeft() != null && wantedNode.getRight() != null){
            
            Node succ = findSuccesorP(value);
            Node succParent = findParent(succ);
            
            if(wantedNode.equals(succParent)){
                Node parent = findParent(wantedNode);

                if(wantedNode.equals(root)){
                    root = succ;
                }

                parent.setRight(succ);

                if(wantedNode.getRight() == succ){
                    
                    succ.setLeft(wantedNode.getLeft());
                }
                else if(wantedNode.getLeft() == succ){

                    succ.setRight(wantedNode.getRight());
                }

                wantedNode = null;
                
                return;
            }   

            if(succ.getLeft() == null && succ.getRight() == null){

                if(succParent.getLeft().equals(succ)){
                    succParent.setLeft(null);
                }
                else{
                    succParent.setRight(null);
                }
            }
            else if(succ.getLeft() == null && succ.getRight() != null){

                if(succParent.getLeft().equals(succ)){
                    succParent.setLeft(succ.getRight());
                }
                else{
                    succParent.setRight(succ.getRight());
                }
                succ.setRight(null);
            }
            else if(succ.getLeft() != null && succ.getRight() == null){

                if(succParent.getLeft().equals(succ)){
                    succParent.setLeft(succ.getLeft());
                }
                else{
                    succParent.setRight(succ.getRight());
                }
                succ.setLeft(null);
            }

            if(wantedNode.equals(root)){
                root = succ;
            }

            succ.setLeft(wantedNode.getLeft());
            succ.setRight(wantedNode.getRight());

            wantedNode = null;

            return;
        }
        
        Node parent = findParent(wantedNode);

        if(wantedNode.getLeft() == null && wantedNode.getRight() == null){

            if(parent.getLeft()!=null && parent.getLeft().equals(wantedNode)){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }

            return;
        }
        
        if(wantedNode.getLeft() == null && wantedNode.getRight() != null){

            if(parent.getLeft()!=null && parent.getLeft().equals(wantedNode)){
                parent.setLeft(wantedNode.getRight());
            }
            else{
                parent.setRight(wantedNode.getRight());
            }
            wantedNode.setRight(null);
            
            return;
        }

        if(wantedNode.getLeft() != null && wantedNode.getRight() == null){

            if(parent.getLeft()!= null && parent.getLeft().equals(wantedNode)){
                parent.setLeft(wantedNode.getLeft());
            }
            else if(parent.getRight()!= null){
                parent.setRight(wantedNode.getLeft());
            }
            wantedNode.setLeft(null);

            return;
        }
    } 

    private Node findParent(Node wantedNode){
        return findParent(root,wantedNode);
    }
    private Node findParent(Node start,Node wantedNode){
        
        if(start.getLeft() != null && start.getRight() != null){

            if(start.getLeft().equals(wantedNode) || start.getRight().equals(wantedNode)){
                return start;
            }

            if(comp.compare(start.getValue(), wantedNode.getValue()) > 0){
                return findParent(start.getLeft(), wantedNode);
            }
            else{
                return findParent(start.getRight(), wantedNode);
            }

        }
        else if(start.getLeft() == null){
            
            if(start.getRight().equals(wantedNode)){
                return start;
            }

            return findParent(start.getRight(), wantedNode);

        }
        else if(start.getRight() == null){

            if(start.getLeft().equals(wantedNode)){
                return start;
            }

            return findParent(start.getLeft(), wantedNode);
        }


        return null;
    }

    public void widePrint(){

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        Node current;

        while(!queue.isEmpty()){
            
            current = queue.poll();
            
            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if(current.getRight() != null){
                queue.add(current.getRight());
            }
            
            System.out.print(current.getValue() + ", ");
        }

    } 

    public void inOrderWalk(exec exec){
        inOrderWalk(root,exec);
    }
    private void inOrderWalk(Node node, exec exec){
        if(node!=null){
            inOrderWalk(node.getLeft(),exec);
            exec.execute(node.getValue());
            inOrderWalk(node.getRight(),exec);
        }
    }

    public BST<T> mostImbalanceSubTree(){
        mostImbalanceSubTree(root);

        Node maxImbalance = root;
        int max = root.getImbalans();
        
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        Node current;

        while(!queue.isEmpty()){
            
            current = queue.poll();
            
            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if(current.getRight() != null){
                queue.add(current.getRight());
            }

            if(current.getImbalans() > max){
                maxImbalance = current;
                max = (int) maxImbalance.getImbalans();
            }
        }
        
        BST<T> result = new BST<>(comp,maxImbalance);

        return result;
    }
    private void mostImbalanceSubTree(Node node){
        
        if(node!=null){
            mostImbalanceSubTree(node.getLeft());
            mostImbalanceSubTree(node.getRight());
            
            if(node.getLeft() == null && node.getRight() == null){
                node.setImbalans(0);
            }
            else if(node.getLeft() == null && node.getRight() != null){
                node.setImbalans(node.getRight().getImbalans() + 1);
            }
            else if(node.getLeft() != null && node.getRight() == null){
                node.setImbalans(node.getLeft().getImbalans() + 1);
            }
            else{
                node.setImbalans(Math.abs(node.getLeft().getImbalans() - node.getRight().getImbalans()));
            }
        }
        
    }

}
