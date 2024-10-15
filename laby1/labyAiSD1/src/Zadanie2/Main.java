package Zadanie2;

public class Main {

    public static void showArray(int[][] arr){
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    static int[] cut(int[] nums, int n){
        
        int[] answer = new int[n];

        for(int i=0;i<n;i++){
            answer[i] = nums[i];
        }
        
        return answer;
    }

    static int[][] cut(int[][] nums , int n){
        
        int[][] answer = new int[n][];

        for(int i=0;i<n;i++){
            answer[i] = nums[i];
        }
        
        return answer;
    }

    static int[][] longestGrowingSubstring(int[] numbers){

        if(numbers==null || numbers.length==0){
            
            System.out.println("Podana tablica jest pusta lub ma wartosc null");
            int[][] a = {};
            return a;
        }

        int[][] a = new int[numbers.length][numbers.length];

        int cols=0;
        int rows=0;

        a[0][0] = numbers[0];

        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>numbers[i-1]){
                rows++;
            }
            else{
                
                a[cols] = cut(a[cols], rows+1);
                cols++;
                rows=0;
                
            } 
            a[cols][rows] = numbers[i];  
        }
        

        a[cols] = cut(a[cols], rows+1);

        a = cut(a,cols+1); 
        
        return a;
    }


    public static void main(String[] args) throws Exception {

        int[] numbers = {1, 2, 8, -3, -3, -4, 7, 10, 0};
        showArray(longestGrowingSubstring(numbers));
        System.out.println("=======");

        int [] numbers1 = {};
        showArray(longestGrowingSubstring(numbers1));
        System.out.println("=======");

        int[] numbers2 = {1,2,3,4,5,6,7};
        showArray(longestGrowingSubstring(numbers2));
        System.out.println("=======");

        int [] numbers3 = {7,6,5,4,3,2,1};
        showArray(longestGrowingSubstring(numbers3));
        System.out.println("=======");

        int [] numbers4 = {1,1,1,1,1,1,1,1,1};
        showArray(longestGrowingSubstring(numbers4));
        System.out.println("=======");

        int[] numbers5 = {1,1,1,2,1,1,1};
        showArray(longestGrowingSubstring(numbers5));
        System.out.println("=======");

        int[] numbers6 = {1};
        showArray(longestGrowingSubstring(numbers6));
        System.out.println("=======");

        int[] numbers7 = null;
        showArray(longestGrowingSubstring(numbers7));
        System.out.println("=======");

    }
}
