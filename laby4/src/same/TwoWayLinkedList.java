package same;
import java.security.InvalidParameterException;

//Ta wersja jest z tym że strażnik i głowa/ogon to te same elementy 

public class TwoWayLinkedList<E>implements IList<E>{
    
    private class Element{
        private E value;
        private Element next;
        private Element previous;

        public Element(E value){
            this.value = value;
        }
        
        public Element getNext() {
            return next;
        }

        public Element getPrevious() {
            return previous;
        }

        public E getValue() {
            return value;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    private Element head;
    private Element tail;

    public TwoWayLinkedList(){
        
        this.head = new Element(null);
        this.head.setPrevious(head);
        this.head.setNext(tail);

        this.tail = new Element(null);
        this.tail.setNext(tail);
        this.tail.setPrevious(head);
    }
    
    
    public boolean isEmpty() {
        return head.getNext() == tail;
    }

    public void clear() {
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public int size() {
        if(isEmpty()){
            return 0;
        }

        int size=1;
        Element tmp = head.getNext();
        
        while(tmp != tail.getPrevious()){
            size++;
            tmp = tmp.getNext();
        }
        
        return size;
    }

    public E get(int index) {
        if(index < 0 || index >= size()){
            throw new InvalidParameterException();
        }
        
        Element tmp = head.getNext();
        while(index > 0){
            
            index--;
            tmp = tmp.getNext();
        }
        
        return tmp.getValue();
    }
 
    public E set(int index, E element) {
        if(index < 0 || index >= size()){
            throw new InvalidParameterException();
        }

        Element tmp = head.getNext();
        while(index > 0){
            index--;
            tmp = tmp.getNext();
        }
        
        E value = tmp.getValue();
        tmp.setValue(element);

        return value;
    }
    
    public boolean add(E e) {

        Element newEL = new Element(e);

        if(isEmpty()){
            
            head.setNext(newEL);
            tail.setPrevious(newEL);

            newEL.setNext(tail);
            newEL.setPrevious(head);

            return true;
        }

        tail.getPrevious().setNext(newEL);
        newEL.setPrevious(tail.getPrevious());
        tail.setNext(tail);

        tail.setPrevious(newEL);

        return true;
    }

    public boolean contains(E element) {

        if(isEmpty()){
            return false;
        }

        Element tmp = head.getNext();

        while(tmp != tail){

            if(tmp.getValue() == element){
                return true;
            }
            tmp = tmp.getNext();
        }
        
        return false;
    }

    public int indexOf(E element) {
        
        if(isEmpty()){
            return -1;
        }

        Element tmp = head.getNext();
        int index = 0;

        while(tmp != tail){

            if(tmp.getValue() == element){
                return index;
            }
            tmp = tmp.getNext();
            index++;
        }
        
        return -1;
    }

    public void add(int index, E element) {
        if(index < 0 || index >=size()){
            throw new InvalidParameterException();
        }
        Element newEl = new Element(element);

        if(index == 0){
            head.getNext().setPrevious(newEl);
            
            newEl.setNext(head.getNext());
            newEl.setPrevious(head);

            head.setNext(newEl);
            
        }
        else{
            Element tmp = head.getNext();
        
            while (index > 0) {
                tmp = tmp.getNext();
                index--;
            }
        
            newEl.setNext(tmp);
            newEl.setPrevious(tmp.getPrevious());
        
            tmp.getPrevious().setNext(newEl);
            tmp.setPrevious(newEl);
        }
    }

    public E remove(int index) {
        
        if(index < 0 || index >=size()){
            throw new InvalidParameterException();
        }        

        if(index == 0){
            E value = head.getNext().getValue();
            
            head.setNext(head.getNext().getNext());
            head.getNext().setPrevious(head);

            return value;
        }
        else if(index == size()-1){
            E value = tail.getPrevious().getValue();

            tail.setPrevious(tail.getPrevious().getPrevious());
            tail.getPrevious().setNext(tail);

            return value;
        }
        else{
            
            Element tmp = head.getNext();
            while(index>0){
                tmp = tmp.getNext(); 
                index--;
            }
        
            tmp.getNext().setPrevious(tmp.getPrevious());
            tmp.getPrevious().setNext(tmp.getNext());

            E value = tmp.getValue();

            tmp = null;;
        
            return value;
        }
    }

    public boolean remove(E element) {
        
        if(contains(element)){
            remove(indexOf(element));

            return true;
        }

        return false;
    }

    public void rotateLeft(int n){

        if(n<0){
            throw new InvalidParameterException();
        }

        if(size() != 0 ){

            n %= size();

            while(n>0){
            
                add(remove(0));

                n--;
            }
        }
    }
}
