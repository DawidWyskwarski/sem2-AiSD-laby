import java.util.LinkedList;
import java.util.Queue;

public class mine {

    static int count;

    static int[] show(int[] a){

        System.out.print("[ ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + ", ");
        }   
        System.out.println(" ]");

        return a;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                count++;
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
    
    static int[] sort(int[] a){

        Queue<int[]> queue = new LinkedList<int[]>();
        int size = a.length;

        for(int i=0;i<size;i++){
            int[] element = new int[1];
            element[0] = a[i];

            queue.add(element);
        }

        while(queue.size()!=1){
            queue.add(merge(show(queue.poll()),show(queue.poll())));
            
        }
        show(queue.peek());
        return queue.poll();
    }



    public static void main(String[] args) {
        
        int[] a = {1,64,5,2,4,2,23,5652,54};

        a = sort(a);

        System.out.println(count);
    }
}