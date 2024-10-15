package Zadanie2;

import java.rmi.NoSuchObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShiftIterator<E> implements Iterator<E> {
    
    private Iter<E> baseIterator;
    private int startIndex;
    

    public ShiftIterator(Iter<E> basIterator) throws NoSuchObjectException{
        if(basIterator != null){
            this.baseIterator = basIterator;
            this.startIndex = 0;
        }
        else{
            throw new NoSuchObjectException("Podany iterator jest nullem");
    
        }
    }

    @Override
    public boolean hasNext() {

        if(baseIterator.hasNext()){
            return true;
        }
        
        startIndex++;
        baseIterator.Goto(startIndex);
        
        //jeśli trzeba też ostatni wyświetlić jeszcze raz (1,2,3,2,3,3) 
        //to trzeba zmienić tą instrukcję na baseIterator.hasNext()
        if(baseIterator.hasNext()){
            return true;
        
        }
        return false;

    }

    @Override
    public E next() {
        if(hasNext()){
            return baseIterator.next();
        }        
        
        throw new NoSuchElementException();
    }
}