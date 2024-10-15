import java.util.Comparator;
import java.util.List;

import core.AbstractSwappingSortingAlgorithm;

public class InsertSort<T> extends AbstractSwappingSortingAlgorithm<T> {

    public InsertSort(Comparator<? super T> comparator){
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();

        for(int i=1; i<size; i++){

            int indexOfinsertion = BinarySearch(list, i-1, list.get(i));

            if(indexOfinsertion != i){
                swap(list,indexOfinsertion,i);
                
                shift(list, indexOfinsertion+1, i);
            }
        }
        
        return list;
    }

    public void shift(List<T> list, int left, int right){

        while(left<right){

            swap(list,right-1,right);

            right--;
        }

    }

    public int BinarySearch(List<T> list, int right, T element){
 
        int left = 0;

        while(left<=right){
            int mid = (left+right)/2;

            if(compare(list.get(mid),element) > 0){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
    
        return left;
    }
}
