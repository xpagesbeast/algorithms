import java.util.Arrays;
import java.util.Scanner;

/*
* Given an unordered set of n distinct integer values, along with a search value v, return a count of the number of triples in the set of values that add up to v.
A triple is a subset of three distinct values from the original set.

Input Format

first line contains the search value v.
second line contains n, the number of values in our set.
third line and on are the set of n integers.
The set of n integers are stored at 50 per line

Constraints

Both v and all set values can be any java integers.
n is a positive integer greater than 3 and less than or equal to 12000
You have to write the code in Java and you will be allowed up to 6 seconds of Hackerrank's CPU time.

Output Format

Simply print out the number of triples you find in the set that add up to v.

Sample Input 0

9
5
1 3 4 6 2

Sample Output 0

2

Explanation 0

Two possible groups of 3 values add up to 9
1, 6, 2
and
3, 4, 2
So we output 2

Sample Input 1

16
12
12 13 5 1 16 15 3 17 24 8 11 2

Sample Output 1

4

Explanation 1

12, 1, 3
13, 1, 2
5, 3, 8
3, 11, 2
Therefore we output: 4
* */
public class FindTriplet {

    public static int counter = 0;

    public static void main(String[] args){
        //find triplets
        Scanner in = new Scanner(System.in);
        int theValue = in.nextInt();
        int setSize = in.nextInt();
        int[] content = new int[setSize];
        for(int i=0;i<setSize;i++){
            content[i] = in.nextInt();
        }

        findNumberOfTriplets(content,setSize,theValue);
        System.out.println(counter);


    }

    private static void findNumberOfTriplets(int A[], int arraySize, int sum)
    {
        int low, high;
        /* Sort the elements */
        quickSort(A, 0, arraySize - 1);

        for (int i = 0; i < arraySize - 2; i++) {
            low = i + 1;
            high = arraySize - 1; // index of the last element
            while (low < high) {
                if (A[i] + A[low] + A[high] == sum) {
                   // System.out.println(" Triplet is " + A[i] + ", " + A[low] + ", " + A[high]);
                    counter++;
                    low++;

                }
                else if (A[i] + A[low] + A[high] < sum)
                    low++;

                else // A[i] + A[low] + A[high] > sum
                    high--;
            }
        }

        // no triplet was found
        //return;
    }

    private static int partition(int A[], int indxStart, int indxEnd)
    {
        int x = A[indxEnd];
        int i = (indxStart - 1);
        int j;

        for (j = indxStart; j <= indxEnd - 1; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[indxEnd];
        A[indxEnd] = temp;
        return (i + 1);
    }

    private static void quickSort(int A[], int indxStart, int indxEnd)
    {
        int pivot;

        /* Partitioning */
        if (indxStart < indxEnd) {
            pivot = partition(A, indxStart, indxEnd);
            quickSort(A, indxStart, pivot - 1);
            quickSort(A, pivot + 1, indxEnd);
        }
    }

}
