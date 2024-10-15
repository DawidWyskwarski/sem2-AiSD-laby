import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryMaxHeap<T extends Comparable<T>> implements BinaryHeap<T>{
    
    private class Element{
        
        private T value;
        private Element left;
        private Element right;
        
        public Element(T value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public Element getLeft() {
            return left;
        }
        public Element getRight() {
            return right;
        }
        public T getValue() {
            return value;
        }
        public void setLeft(Element left) {
            this.left = left;
        }
        public void setRight(Element right) {
            this.right = right;
        }
        @SuppressWarnings("unused")
        public void setValue(T value) {
            this.value = value;
        }

    }

    private Element root;
    private int size;

    public BinaryMaxHeap(){
        this.root = null;
        this.size = 0;
    }

    public void show(){
        show(root);
    }

    public int getSize() {
        return size;
    }
    
    public void clear() {
        root = null;
        size = 0;
    }

    public void add(T element) {
        Element newEl = new Element(element);

        if(element == null){
            throw new IllegalArgumentException();
        }
        
        size++;
        if(root == null){
            root = newEl;

            return;
        }
        
        Element search = findIndex(size/2);

        if(search.getLeft() == null){
            search.setLeft(newEl);
        }
        else{
            search.setRight(newEl);
        }

        fix(newEl, size);
    }

    public T maximum() {
        
        if(size==0){
            throw new NoSuchElementException("Empty collection");
        }

        T value = root.getValue();

        if(size == 1){
            clear();
            
            return value;
        }

        Element last = findIndex(size);
        Element lastParent = findIndex(size/2);

        if(size%2 == 0){
            lastParent.setLeft(null);
        }
        else{
            lastParent.setRight(null);
        }

        last.setLeft(root.getLeft());
        last.setRight(root.getRight());
        root = last;

        sink(root,1);

        size--;

        return value;

    }

    public void widePrint(){

        Queue<Element> queue = new LinkedList<Element>();
        queue.add(root);

        Element current;

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

    private void swapLeft(Element el, int index){

        int parentIndex = index/2;
        int grandparentIndex = parentIndex/2;
        Element parent = findIndex(parentIndex);
        Element grandparent = findIndex(grandparentIndex);

        if(parentIndex == 1){
            root = el;
        }

        Element r = parent.getRight(); 

        parent.setLeft(el.getLeft()); 
        parent.setRight(el.getRight()); 

        el.setLeft(parent);
        el.setRight(r);
        
        if(parentIndex/2 != 0){
            if(parentIndex%2 == 0){
                grandparent.setLeft(el);
            }
            else{
                grandparent.setRight(el);
            }
        }

    }

    private void swapRight(Element el, int index){

        int parentIndex = index/2;
        int grandparentIndex = parentIndex/2;
        Element parent = findIndex(parentIndex);
        Element grandparent = findIndex(grandparentIndex);

        if(parentIndex == 1){
            root = el;
        }

        Element l = parent.getLeft();

        parent.setLeft(el.getLeft());
        parent.setRight(el.getRight());

        el.setRight(parent);
        el.setLeft(l);

        if(parentIndex/2 != 0){
            if(parentIndex%2 == 0){
                grandparent.setLeft(el);
            }
            else{
                grandparent.setRight(el);
            }
        }

    }

    private void sink(Element el,int index){

        if(el.getLeft() == null && el.getRight() == null){
            return;
        }
        else if(el.getLeft() != null && el.getRight() == null){

            if(el.getValue().compareTo(el.getLeft().getValue()) < 0){
                
                swapLeft(el.getLeft(), 2*index);
            }
        }
        else if(el.getRight() != null && el.getLeft() == null){

            if(el.getValue().compareTo(el.getRight().getValue()) < 0){
                
                swapRight(el.getRight(), 2*index+1);
            }
        }
        else if(el.getLeft().getValue().compareTo(el.getRight().getValue()) > 0){

            swapLeft(el.getLeft(), 2*index);
            sink(el,2*index);
        }
        else if(el.getLeft().getValue().compareTo(el.getRight().getValue()) < 0){

            swapRight(el.getRight(), 2*index+1);
            sink(el,2*index + 1);
        }
    }

    private void fix(Element el,int index){

        int parentIndex = index/2;

        Element parent = findIndex(parentIndex);

        if(index%2 == 0){

            if(parent.getValue().compareTo(el.getValue()) < 0){

                swapLeft(el, index);
                fix(el, parentIndex);
            }

        }else{
            
            if(parent.getValue().compareTo(el.getValue()) < 0){

                swapRight(el,index);
                fix(el, parentIndex);
            } 
        }
    }

    private Element findIndex(int index){
        String code = Integer.toBinaryString(index);
        
        Element search = root;
        for(int i=1;i<code.length();i++){

            if(code.charAt(i) == '0'){
                search = search.getLeft();
            }
            else{
                search = search.getRight();
            }
        }

        return search;
    }

    private void show(Element element){

        if(element == null){
            return;
        }else{
            System.out.println(element.getValue());
            
            show(element.getLeft());
            show(element.getRight());
        }

    }
}
