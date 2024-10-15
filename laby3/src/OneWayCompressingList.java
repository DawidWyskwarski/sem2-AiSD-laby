public class OneWayCompressingList<E> {
    
    private class Element{
        E value;
        Element next;

        E[] arrayValue;
        
        public Element(E value){
            this.value = value;
            this.next = null;
            this.arrayValue = null;
        }

        public Element(E[] arrayValue){
            this.arrayValue = arrayValue;
            this.value = null;
            this.next = null;
        }
    }

    Element head;
    private int C;
    private int size; 
    private int NotCompressed;

    public OneWayCompressingList(int C){
        this.C = C;
        this.head = null;
        this.size = 0;
        this.NotCompressed = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void clear(){
        head = null;
    }

    public int size(){
        return size;
    }

    public E[] getHead() {
        return head.arrayValue;
    }

    public boolean add(E e){

        Element newElement = new Element(e);
        
        if(head == null){
            head = newElement;
            size++;
            NotCompressed++;
            return true;    
        }

        if(size<C){
            Element tail = head;
            
            while(tail.next != null){
                tail = tail.next; 
            }

            tail.next = newElement;
            size++;
            NotCompressed++;
        }
        else{
            shift(newElement);
            NotCompressed++;
        }   
        
        if(NotCompressed == C){
            Compress();
        }

        return true;
    }

    public void shift(Element e){

        if(NotCompressed!=0){
            Element last = head;

            while(last.next!=null){
                last = last.next;
            }
            Element LastPom;

            do{
                LastPom = head;
            
                while(LastPom.next!=last){
                    LastPom = LastPom.next;
                }

                e = new Element( OneOut(last.arrayValue, e.value) );

                last = LastPom;

            }while(last.value!=null);

            Element firstArray = last.next;
            last.next = e;
            e.next = firstArray;
        }
        else{
            e = new Element( OneOut(head.arrayValue, e.value) );

            Element firstArray = head;
            head = e;
            head.next = firstArray;
        }
    }

    @SuppressWarnings("unchecked")
    private E OneOut(E[] tablica, E element){
        
        E value = tablica[0];
        
        E[] newTab = (E[]) new Object[tablica.length];

        for(int i=0;i<newTab.length-1;i++){
            newTab[i] = tablica[i+1];
        }
        newTab[newTab.length-1] = element;

        //nie działa, tablica nie jest updatowana
        tablica = newTab;

        return value;
    }

    public void Compress(){
        
        Element el = head;

        @SuppressWarnings("unchecked")
        E[] tablica = (E[]) new Object[C];


        for(int i=0;i<C;i++){
            tablica[i] = el.value;
            el = el.next;
        }

        head = new Element(tablica);
        head.next = el;
        NotCompressed = 0;
    }

    public E getElement(int index){

        E value = head.value;
        Element el = head;

        for(int i=0;i<index;i++){

            if(el.arrayValue == null){
                el = el.next;
                value = el.value;
            }
            else{
                for(int j=0;j<el.arrayValue.length && i<index ;j++){
                    value = el.arrayValue[j];
                    i++;
                }
                el = el.next;
                
            }   
        }
        return value;
    }
}
