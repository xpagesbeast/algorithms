import java.time.LocalDateTime;
import java.util.Date;

public class RecursivePractice {
    public static void main(String[] args){
        int r=16;
        int c=16;
        Date start = new Date();
        long n = numPaths(r,c);
        Date end = new Date();
        System.out.println("Number of pats from " + r + ", " + c + " is " + n + ": " + ((start.getTime() - end.getTime())/60));

    }

    public static long numPaths(int r, int c){
        //working towards destination
        if(r<=0 && c<=0){
            return 1;
        }

        if(c==0){
            return 1;
        }

        if(r==0){
            return 1;
        }

        long np = numPaths(r-1,c) + numPaths(r,c-1);
        return np;
    }

}
