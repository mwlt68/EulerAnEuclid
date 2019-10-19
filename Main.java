import java.io.Console;
import java.util.Scanner;


public class Main {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String...Args){
        menuWrite();
        int value=getValue();

        while(true){
            while(value ==-1){
                value=getValue();
            }
            if(!getProcess(value)){
                break;
            }
            value=getValue();
        }
    }

    public static  void menuWrite(){
        System.out.println("1- Euler Algorithm ");
        System.out.println("2- Euclid Diametrical Algorithm");
        System.out.println("3- Euclid Algorithm");
        System.out.println("4- Exit");
        System.out.println("Please, Enter a value :");
    }
    public static boolean getProcess(int value){
        switch (value)
        {
            case 1:
                EulerAlgorithm();
                return  true;
            case 2:
                EuclidDiametricalAlgorithm();
                return true;
            case 3:
                EuclidAlgorithm();
                return true;
            default:
                return false;

        }
    }
    public static int getValue(){
        int val;
        String enterVal="";
        enterVal=scanner.nextLine();
        try {
            val=Integer.parseInt(enterVal);
            return  val;
        }catch (Exception e){
            System.out.println("Please ,Enter a numerical value !");
            return -1;
        }
    }

    public static void EuclidDiametricalAlgorithm(){
        System.out.println("Please,Enter positive two values :");
        int value=0;
        int moduleValue=0;
        try {
            System.out.println("Please,Enter  value :");
            value=scanner.nextInt();
            System.out.println("Please,Enter module value :");
            moduleValue=scanner.nextInt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (! isPositive(value,moduleValue)){
            System.out.println("Please ,Enter positive number !");
            return;
        }
        int tempVal=value;
        int tempModule=moduleValue;
        int t0=0,t=1;
        int q=(int)Math.floor(tempModule/tempVal);
        int r= tempModule-q * tempVal;
        while (r>0){
            int temp=t0-q*t;
            if (temp >=0)
                temp=temp % moduleValue;
            else
                temp=moduleValue-((-temp)%moduleValue);
            t0=t;
            t=temp;
            tempModule=tempVal;
            tempVal=r;
            q=(int)Math.floor(tempModule/tempVal);
            r= tempModule-q * tempVal;
        }
        if (tempVal != 1)
            System.out.println("There is no diametrical Euclid !");
        else
            System.out.println("Diametrical Euclid of value :" +(t% moduleValue));
    }
    public static void  EulerAlgorithm(){
        System.out.println("Please,Enter positive three values :");
        int value=0;
        int baseVal=0;
        int moduleVal=0;
        try {
            System.out.println("Please,Enter  value :");
            value=scanner.nextInt();
            System.out.println("Please,Enter base value :");
            baseVal=scanner.nextInt();
            System.out.println("Please,Enter module value :");
            moduleVal=scanner.nextInt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (! isPositive(value,baseVal,moduleVal)){
            System.out.println("Please ,Enter positive number !");
            return;
        }
        int result=1;
        while(baseVal != 0){
            if (baseVal % 2==1){
                result=(result*value)%moduleVal;
                baseVal--;
            }
            else{
                value=(value*value)%moduleVal;
                baseVal/=2;
            }
        }
        System.out.println("Result :" +result);
    }
    public static void  EuclidAlgorithm(){
        System.out.println("Please,Enter positive two values :");
        int bigVal=0;
        int smallVal=0;
        try {
            System.out.println("Please,Enter small value :");
             smallVal=scanner.nextInt();
            System.out.println("Please,Enter big value :");
            bigVal=scanner.nextInt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (smallVal> bigVal){
            int temp=bigVal;
            bigVal=smallVal;
            smallVal=temp;
        }
        if (! isPositive(smallVal,bigVal)){
            System.out.println("Please ,Enter positive number !");
            return;
        }
        while (true){
            int divided=bigVal/smallVal;
            int remain=bigVal % smallVal;
            System.out.println(bigVal+" = "+ divided+" * "+smallVal+" + "+remain);
            if (remain==0){
                System.out.println("Result: "+smallVal);
                break;
            }
            bigVal=smallVal;
            smallVal=remain;
        }
    }
    public static boolean isPositive(int... values){
        for (int val:values) {
            if (val<=0)
                return  false;
        }
        return  true;
    }
}
