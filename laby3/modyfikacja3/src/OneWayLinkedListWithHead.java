public class OneWayLinkedListWithHead<E> {
    class Element{

		private E value;
		private Element next;

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Element getNext() {
			return next;
		}

		public void setNext(Element next) {
			this.next = next;
		}



		Element(E data){
			this.value=data;
		}
	}

    Element head=null;

	public OneWayLinkedListWithHead(){
	}

    public boolean isEmpty(){
		return head==null;
	}
	
	public void clear() {
		head=null;
	}
	
	public int size() {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			pos++;
			actElem=actElem.getNext();
		}
		return pos;
	}

    private Element getElement(int index){
		Element actElem=head;
		while(index>0 && actElem!=null){
			index--;
			actElem=actElem.getNext();
		}
		return actElem;		
	}

    public Element last(){
        Element actElem=head;
		
        while(actElem.getNext()!=null)
		{
			actElem=actElem.getNext();
		}

        return actElem;
    }

    public Element head(){
        return head;
    }

	public boolean add(E e) {
		Element newElem=new Element(e);
		if(head==null){
			head=newElem;
			return true;
		}
		Element tail=head;
		while(tail.getNext()!=null)
			tail=tail.getNext();
		tail.setNext(newElem);
		return true;
	}

	public boolean add(int index, E data) {
		if(index<0) return false;
		Element newElem=new Element(data);
		if(index==0)
		{
			newElem.setNext(head);
			head=newElem;
			return true;
		}
		Element actElem=getElement(index-1);
		if(actElem==null)
			return false;
		newElem.setNext(actElem.getNext());
		actElem.setNext(newElem);
		return true;
	}

	public int indexOf(E data) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem.getValue()==data)
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}

    public boolean contains(E data) {
		return indexOf(data)>=0;
	}

	public E get(int index) {
		Element actElem=getElement(index);
		return actElem==null?null:actElem.getValue();
	}

	public E set(int index, E data) {
		Element actElem=getElement(index);
		if(actElem==null)
			return null;
		E elemData=actElem.getValue();
		actElem.setValue(data);
		return elemData;
	}

	public E remove(int index) {
		if(head==null)
			return null;
		if(index==0){
			E retValue=head.getValue();
			head=head.getNext();
			return retValue;
		}
		Element actElem=getElement(index-1);
		if(actElem==null || actElem.getNext()==null)
			return null;
		E retValue=actElem.getNext().getValue();
		actElem.setNext(actElem.getNext().getNext());
		return retValue;
	}

	
	public boolean remove(E value) {
		if(head==null)
			return false;
		if(head.getValue().equals(value)){
			head=head.getNext();
			return true;
		}

		Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value))
			actElem=actElem.getNext();

		if(actElem.getNext()==null)
			return false;
		actElem.setNext(actElem.getNext().getNext());
		return true;
	}

    public boolean remove(Element el){
        if(head == null)
            return false;

        if(head.equals(el)){
            head = head.getNext();
            return true;
        }    

        Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().equals(el))
			actElem=actElem.getNext();

		if(actElem.getNext()==null)
			return false;
		actElem.setNext(actElem.getNext().getNext());
		return true;
    }


}
