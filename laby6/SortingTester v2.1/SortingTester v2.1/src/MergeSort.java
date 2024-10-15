import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import core.AbstractSortingAlgorithm;

public class MergeSort<T> extends AbstractSortingAlgorithm<T>{
    
    public MergeSort(Comparator<? super T> comparator) {
		super(comparator);
	}
    
    private List<T> merge(List<T> left, List<T> right) {
        
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>)new ArrayList<Object>();
        
        Iterator<T> l = left.iterator();
        Iterator<T> r = right.iterator();
        
        T elemL=null,elemR=null;
        
        boolean contL,contR;
        
        if(contL=l.hasNext()) elemL=l.next();
        if(contR=r.hasNext()) elemR=r.next();
        
        while (contL && contR) {
            if (compare(elemL, elemR) <= 0){
                result.add(elemL);
                if(contL=l.hasNext()) elemL=l.next();
                else result.add(elemR);} 
            else {
                result.add(elemR);
                if(contR=r.hasNext()) elemR=r.next();
                else result.add(elemL);} 
        }
        
        while(l.hasNext()) result.add(l.next());
        
        while(r.hasNext()) result.add(r.next());
        
        return result;
    }
    
    public List<T> sort(List<T> list) {

        Queue<List<T>> queue = new LinkedList<List<T>>();

        for (T element : list) {
            List<T> singleElementList = new ArrayList<>();
            singleElementList.add(element);
            
            queue.add(singleElementList);
        }

        while(queue.size()!=1){
            queue.add(merge(queue.poll(),queue.poll()));
        }

        return queue.poll();
    }
}
