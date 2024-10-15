package Zadanie1;

public class MainB {
    
    public static void drawBridge(int n){

        if(n<0){
            System.out.println("Podales niepoprawne n");
        }
        
        if(n==1){
            System.out.println("X");
        }else{
        
            for(int i=0;i<n;i++){
            
                if(i==n-2){
                
                    for(int j=0;j < 2*n-1 ;j++){
                        System.out.print("X");
                    }
                }
                else{

                    System.out.print("I");

                    if(i>0 && i<n-2){
                    
                        for(int j=0; j< 2*n-3 ;j++){
                            
                            if(j<n-1){

                                if(j==i-1){
                                    System.out.print("\\");
                                }
                                else{
                                    System.out.print(" ");
                                }
                            }
                            else{
                            
                                if(j==2*n-3-i){
                                    System.out.print("/");
                                }
                                else{
                                    System.out.print(" ");
                                }
                            }
                        }
                    }
                    else{
                        for(int j=0;j<2*n-3;j++){
                            System.out.print(" ");
                        }
                    }

                    System.out.print("I");
                }
                System.out.println("");
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("n: 0");
        drawBridge(0);
        System.out.println("=============");

        System.out.println("n: 1");
        drawBridge(1);
        System.out.println("=============");

        System.out.println("n: 2");
        drawBridge(2);
        System.out.println("=============");

        System.out.println("n: 3");
        drawBridge(3);
        System.out.println("=============");

        System.out.println("n: 4");
        drawBridge(4);
        System.out.println("=============");

        System.out.println("n: 5");
        drawBridge(5);
        System.out.println("=============");

        System.out.println("n: 6");
        drawBridge(6);
        System.out.println("=============");

        System.out.println("n: 10");
        drawBridge(10);
        System.out.println("=============");

        System.out.println("n: -1");
        drawBridge(-1);
        System.out.println("=============");

    }
}
