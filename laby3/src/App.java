public class App {
    
    static int OneOut(int[] tablica, int element){
        
        int value = tablica[0];
        
        int[] newTab = new int[tablica.length];

        for(int i=0;i<newTab.length-1;i++){
            newTab[i] = tablica[i+1];
        }
        newTab[newTab.length-1] = element;

        tablica = newTab;

        

        return value;
    }
    
    
    public static void main(String[] args) throws Exception {
        
        OneWayCompressingList<Integer> test = new OneWayCompressingList<>(5);

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        //test.add(6);
        
        Object[] tab =  test.getHead();

        /*for(int i=0;i<tab.length;i++){
            System.out.println(tab[i]);
        }*/

        int[] arr = {1,2,3};
        
        int left = OneOut(arr, 0);

        System.out.println(left);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
