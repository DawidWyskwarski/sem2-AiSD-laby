public class Modyfikacja {
    
    static int GrowingSubstringSpan(int[] numbers){

        if(numbers == null || numbers.length==0){
            System.out.println("Pusta tablica lub tablica rowna null");
            return -1;
        }

        int rows=0;
        int maxRows=0;
        int minRows = numbers.length;

        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>numbers[i-1]){
                rows++;
            }
            else{
                
                if(minRows>rows){
                    minRows = rows;
                }

                if(maxRows<rows){
                    maxRows = rows;
                }

                rows=0;   
        
            } 
        }
        
        if(minRows>rows){
            minRows = rows;
        }

        if(maxRows<rows){
            maxRows = rows;
        }

        System.out.println(++minRows);
        System.out.println(++maxRows);
        return maxRows-minRows;
    }
    
    public static void main(String[] args) throws Exception {
        
        int[] numbers = {1,2,8, -3, -3, -4,7,10, 1};
        System.out.println(GrowingSubstringSpan(numbers));
        System.out.println("=======");

        int [] numbers1 = {};
        System.out.println(GrowingSubstringSpan(numbers1));
        System.out.println("=======");
        
        int[] numbers2 = {1,2,3,4,5,6,7};
        System.out.println(GrowingSubstringSpan(numbers2));
        System.out.println("=======");

        int [] numbers3 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(GrowingSubstringSpan(numbers3));
        System.out.println("=======");

        int [] numbers4 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(GrowingSubstringSpan(numbers4));
        System.out.println("=======");

        int[] numbers5 = {1, 1, 1,2, 1, 1, 1};
        System.out.println(GrowingSubstringSpan(numbers5));
        System.out.println("=======");

        int[] numbers6 = {1};
        System.out.println(GrowingSubstringSpan(numbers6));
        System.out.println("=======");

        int[] numbers7 = {1,2,3,4, 1,2,3,4,5, 1,2,3, 1,2,3,4,5,6, 1,2,3,4,5};
        System.out.println(GrowingSubstringSpan(numbers7));
        System.out.println("=======");

        int[] numbers8 = {1,2,3,4,5,6,7,1};
        System.out.println(GrowingSubstringSpan(numbers8));
        System.out.println("=======");
    
        
        int[] numbers9 = null;
        System.out.println(GrowingSubstringSpan(numbers9));
        System.out.println("=======");
    }
}
