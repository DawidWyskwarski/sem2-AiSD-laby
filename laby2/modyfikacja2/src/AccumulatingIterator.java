import java.rmi.NoSuchObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AccumulatingIterator implements Iterator<Number> {

    private Iterator<Number> baseIterator;
    private Number sum;

    public AccumulatingIterator(Iterator<Number> baseIterator) throws NoSuchObjectException{
        
        if(baseIterator!=null){
            this.baseIterator = baseIterator;
            this.sum = 0;
        }
        else{
            throw new NoSuchObjectException("Podany iterator jest nullem");
        }
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public Number next() {
        if(hasNext()){
            Number element = baseIterator.next();
            sum = element.doubleValue() + sum.doubleValue(); 

            return sum;
        }
        throw new NoSuchElementException();
    }
}
