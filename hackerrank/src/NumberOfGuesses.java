import java.util.Scanner;

public class NumberOfGuesses {
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startValue = in.nextInt();
        int endValue = in.nextInt();

        if(startValue > endValue){
            int tmp = startValue;
            startValue = endValue;
            endValue = tmp;
        }

        calculateGuesses(startValue,endValue);
        System.out.println(counter);
    }

    public static void calculateGuesses(int low, int high){




        if(low > high){
            return;
        }

        counter++;

        if(low == high){

            return;
        }

        int mid = (int)(low + high)/2;

        calculateGuesses(low,mid);

        return;
    }
}

