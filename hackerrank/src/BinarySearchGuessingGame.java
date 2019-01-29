import java.util.Scanner;

/*
* Given 3 integer values - low, high, and secretNum, display the list of values you would make if you tried to guess the secret number by means of binary search.

Input Format

Input is three space separated values. First value is the low, second is the high, third is the secret number we are trying to guess.
Think about how your guess is made: What is the largest value an integer can have? What happens if both are low and high values are really close to the largest value possible? This could be a reason if you are getting an error on the second test case.

Constraints

all three values are valid Java integers. The secret number is guaranteed to be greater than or equal to the low value and less than or equal to the high value.

Output Format

On a single line, display all the guesses we would make if we didn't know the secret number but instead used our binary search technique and relied on information after each guess whether we guessed too high or too low.

Sample Input 0

1 10 7

Sample Output 0

5 8 6 7

Explanation 0

From the input: low = 1, high = 10, The number we are trying to guess is 7

Our first guess is 5 --> too low. We are now looking for a number between 6 and 10

Our second guess is 8 --> too high. We are now looking for a number between 6 and 7

Our third guess is 6 --> too low. Remember, we are looking at integer values, no rounding! We are now looking for a number between 7 and 7

Our fourth guess is 7 --> found it!

Sample Input 1

110 100 104

Sample Output 1

105 102 103 104

Explanation 1

first guess --> 105. Too high, so that eliminates 105 through 110

second guess --> 102. Too low, so that eliminates 100, 101, and 102

third guess --> 103. Too low, that leaves:

fourth guess --> 104. Found it!

Just how do we calculate our guess? What happens if we are searching through really large values?
*
* */
public class BinarySearchGuessingGame {
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startValue = in.nextInt();
        int endValue = in.nextInt();
        int answer = in.nextInt();

        if(startValue > endValue){
            int tmp = startValue;
            startValue = endValue;
            endValue = tmp;
        }

        int guess = binarySearch(startValue,endValue,answer);

    }

    public static int binarySearch(double low, double high, int value){
/*
        if(low > high){
            System.out.print((int)low);
            return search[(int)low];
        }
*/
        counter++;
        int mid = (int)((low + high) / 2);


        if(value == mid){
            System.out.print(mid);
            return value;
        }

        System.out.print(mid + " ");

        if(mid < value){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
        return binarySearch(low, high, value);
    }
}
