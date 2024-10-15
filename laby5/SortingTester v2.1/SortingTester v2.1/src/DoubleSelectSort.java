import java.util.Comparator;
import java.util.List;

import core.AbstractSwappingSortingAlgorithm;

public class DoubleSelectSort<T> extends AbstractSwappingSortingAlgorithm<T> {
    
    public DoubleSelectSort(Comparator<? super T> comparator) {
		super(comparator);
	}

    @Override
    public List<T> sort(List<T> list) {

        int min=0;
        int max=0;

        for(int i=0;i< (list.size()/2) ;i++){

            for(int j=i;j<list.size()-i;j++){
                if(j==i){
                    min = j;
                }
                
                if(compare(list.get(min), list.get(j)) > 0){
                    min = j;
                }
            }

            swap(list, min, i);
            MoveElementsDown(list, i+1, min);

            for(int j = list.size()-i-1;j>i;j--){
                if(j == list.size()-i-1){
                    max = j;
                }
                
                if(compare(list.get(max), list.get(j)) < 0){
                    max = j;
                }
            }
            swap(list, max, list.size()-1-i);
            MoveElementsUp(list, max,list.size()-2-i );
        }

        return list;
    }
    
    public void MoveElementsDown(List<T> list, int start, int end){
        while(start < end){
            swap(list, end, end-1);
            end--;
        }
        
    }

    public void MoveElementsUp(List<T> list, int start, int end){
        while(start < end){
            swap(list, start, start+1);
            start++;
        }
        
    }
}
