public class modyfikacja3 {
    
    @SuppressWarnings("unchecked")
    static int palindromeBreakIndex(int start, OneWayLinkedListWithHead lista) throws InterruptedException{

        if(lista.head() == null || lista ==null){
            return -1;
        }

        if(lista.head().getValue() == lista.last().getValue()){
            lista.remove(lista.head());
            
            if(lista.head() != null){
                lista.remove(lista.last());
            }
            
            start++;
            
            for(int i=0;i<lista.size();i++){
                System.out.println(lista.get(i));
            }
            System.out.println("======");
            

             
            return palindromeBreakIndex(start, lista);
        }
        else{
            return start;
        }


    }
    
    
    public static void main(String[] args) throws Exception {
        
        OneWayLinkedListWithHead<Integer> test = new OneWayLinkedListWithHead<>();

        test.add(1);
        test.add(1);
        test.add(3);
        test.add(3);
        test.add(1);
        test.add(1);
        
        System.out.println(palindromeBreakIndex(0, test));
    }
}
