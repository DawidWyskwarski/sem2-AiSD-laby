package Zadanie2;

import java.rmi.NoSuchObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iter<E> implements Iterator<E> {
    
    private E[] array;
    private int pos;

    public Iter(E[] array) throws NoSuchObjectException{
        if(array == null){
            throw new NoSuchObjectException("Podana tabblica jest nullem");
        }
        this.array = array;
        pos = 0; 
    }

    @Override
    public boolean hasNext() {
        if(array!=null){
            return pos<array.length;
        }
        return false;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E element = array[pos];
            pos++;
            return element;
        }
        throw new NoSuchElementException();
    }

    public void Goto(int index){
        this.pos = index;
    }
}
