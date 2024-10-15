import java.util.Comparator;
import java.util.List;

import core.AbstractSwappingSortingAlgorithm;

public class ShakerSort<T> extends AbstractSwappingSortingAlgorithm<T> {
    
    public ShakerSort(Comparator<? super T> comparator){
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        boolean change = false;
        int Lastsorted = 0;
        int Firstsorted = 0;
        int i = 0;

        do{

            change = false;

            for(;i<list.size()-1-Lastsorted;i++){
                if(compare(list.get(i),list.get(i+1)) > 0){
                    swap(list, i, i+1);
                    change = true;
                }
                
            }
            Lastsorted++;

            for(;i>=1+Firstsorted;i--){
                if(compare(list.get(i), list.get(i-1)) < 0){
                    swap(list, i, i-1);
                    change = true;
                }
                
            }
            Firstsorted++;

        }while(change);

    
        return list;
    }
}
