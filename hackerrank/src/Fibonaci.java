public class Fibonaci {
    //series
    //start with one pair of rabbits.
    //how many pair of rabbits you have every month.
    //1,1,2,3,5,8,13
    //for n > 1 f(n) = f(n-1) + f(n-2)
    // n<= 1 : n this is stopping condition.
    public static void main(String[] args){

        for(int i=0; i<50; i++) {
            System.out.println(f(i));
        }
    }

    private static long f(long n){
        //long 8 bytes... overflows
        if(n<=1) return n;
        return f(n-1) + f(n-2);
    }
}
