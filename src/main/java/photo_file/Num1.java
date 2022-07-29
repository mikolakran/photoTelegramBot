package photo_file;

public class Num1 {
    public static Num1 instance ;

    private Num1() {
    }

    public static synchronized Num1 getInstance(){
        if (instance==null){
            instance = new Num1();
        }
        return instance;
    }

    public int plus(int sum, int sum2){
        sum =sum + sum2;
        return sum;
    }

    public int minus(int sum,int sum2){
        sum = sum - sum2;
        return sum;
    }

    public int division(int sum,int sum2){
        sum =sum / sum2;
        return sum;
    }

    public int multiplication(int sum,int sum2){
        sum = sum * sum2;
        return sum;
    }

}
