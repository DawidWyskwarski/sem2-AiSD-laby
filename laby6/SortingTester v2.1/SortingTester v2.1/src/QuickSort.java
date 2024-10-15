import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import core.AbstractSwappingSortingAlgorithm;

public class QuickSort<T> extends AbstractSwappingSortingAlgorithm<T>{
    
    private PivotFirst pivot;

    public QuickSort(Comparator<? super T> comparator, PivotFirst pivot) {
		super(comparator);
        this.pivot = pivot;
    }

    public List<T> sort(List<T> list) {
        quicksort(list, 0, list.size());
        return list;
    }
    
    private void quicksort(List<T> list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition );
            quicksort(list, partition + 1, endIndex);
        }
    }
        
    private int partition(List<T> list, int nFrom, int nTo) {
        
        int pv = pivot.choosePivot(nFrom, nTo);

        swap(list, pv, nFrom);

        T value = list.get(nFrom);

        int l = nFrom+1;
        int r = nTo-1;
        
        ListIterator<T> leftIter = list.listIterator(l);
        ListIterator<T> rightIter = list.listIterator(nTo);

        T elementL = null;
        T elementR = null;

        if(leftIter.hasNext()){
            elementL = leftIter.next();
        }
        
        if(rightIter.hasPrevious()){
            elementR = rightIter.previous();
        }
        
        
        while (l <= r) {
            while (l <= r && compare(elementL, value) <= 0) {
                l++;
                if (l <= r && leftIter.hasNext()) {
                    elementL = leftIter.next();
                }
            }
    
            while (l <= r && compare(elementR, value) > 0) {
                r--;
                if (l <= r && rightIter.hasPrevious()) {
                    elementR = rightIter.previous();
                }
            }
    
            if (l < r) {
                swap(list, l, r);
                
                if (l <= r && leftIter.hasNext()) {
                    elementL = leftIter.next();
                }
                if (l <= r && rightIter.hasPrevious()) {
                    elementR = rightIter.previous();
                }
                l++;
                r--;
            }
        }
    
        swap(list, l - 1, nFrom);
    
        return l - 1;
    }
    

}
