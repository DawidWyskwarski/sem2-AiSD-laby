package Zadanie1;

public class MainA {
    
    public static void drawZigZag(int n, int l){

        if(n<0 || l<0){
            System.out.println("Podales niepoprawne dane n oraz l musza byc dodatnie");
        }
        
        final int height = 4;

        for(int i=0;i<n;i++){

            int pom = i%(height*2);
            
            if(pom <= height){
            
                for(int j=0;j<pom% (height+1);j++){
                    System.out.print(" ");
                } 
                
            }else{

                for(int j=(height-1) - pom % (height + 1); j>0 ;j--){
                    System.out.print(" ");
                }

            }
            
            for(int j=0;j<l;j++){
                System.out.print("X");
            }

            System.out.println("");
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("n: 0");
        drawZigZag(0, 5);
        System.out.println("=============");

        System.out.println("n: 4");
        drawZigZag(4, 5);
        System.out.println("=============");

        System.out.println("n: 5");
        drawZigZag(5, 5);
        System.out.println("=============");

        System.out.println("n: 7");
        drawZigZag(7, 5);
        System.out.println("=============");

        System.out.println("n: 8");
        drawZigZag(8, 5);
        System.out.println("=============");

        System.out.println("n: 9");
        drawZigZag(9, 5);
        System.out.println("=============");

        System.out.println("n: 12");
        drawZigZag(12, 5);
        System.out.println("=============");

        System.out.println("n: 16");
        drawZigZag(16, 5);
        System.out.println("=============");

        System.out.println("n: -1");
        drawZigZag(-1, 5);
        System.out.println("=============");
    }
}
