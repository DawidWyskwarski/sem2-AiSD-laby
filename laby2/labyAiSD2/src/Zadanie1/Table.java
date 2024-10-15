package Zadanie1;
import java.rmi.NoSuchObjectException;
import java.util.Iterator;

public class Table<E> implements Iterable<E> {

    private E[] array;

    @SuppressWarnings("unchecked")
    public Table(int size){
        array = (E[]) new Object[size];
    }

    public void set(int index, E element){
        array[index] = element;
    }

    public E get(int index){
        return array[index];
    }

    public int size(){
        return array.length;
    }

    @Override
    public Iterator<E> iterator() {
        try {
            return new TableIterator<E>(array);
        
        } catch (NoSuchObjectException e) {

            e.printStackTrace();
        }
        return null;
    }
}
