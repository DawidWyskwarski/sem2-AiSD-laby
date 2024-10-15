package Zadanie1;
import java.rmi.NoSuchObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TableIterator<E> implements Iterator<E> {
    private int pos;
    private E[] array;

    public TableIterator(E[] array) throws NoSuchObjectException{
        if(array == null){
            throw new NoSuchObjectException("Podana tablica jest nullem");
        }
        this.array = array;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;    
    }

    @Override
    public E next() {
        if(hasNext()){
            E element = array[pos];
            pos++;
            return element;
        }
        throw new NoSuchElementException();
    }
}
