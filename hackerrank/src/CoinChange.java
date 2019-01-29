import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
   * In US currency, a quarter is worth 25 cents, a dime is worth 10 cents, a nickel is worth 5 cents, and a penny is worth 1 cent. Write a Java program that reads an integer representing a dollar amount consisting of all pennies. You may assume the user input value is greater than zero. The program is to distribute that amount into quarters, dimes, nickels and pennies, using as few coins as possible.

Input Format

One integer value amt that is the number of pennies to be converted

Constraints

1 <= amt

Output Format

Write the number of quarters, dimes, nickels and pennies that equal amount amt.
The coin type is lowercase and properly pluralized if necessary. If the number of coins required for a particular denomination is 0, that coin is not included as part of the solution.

Sample Input 0

97

Sample Output 0

3 quarters
2 dimes
2 pennies

Explanation 0

the least number of quarters, dimes, nickels, or pennies required to make 97 cents is 3 quarters, 2 dimes, and 2 pennies

Sample Input 1

96

Sample Output 1

3 quarters
2 dimes
1 penny

Explanation 1

the fewest number of quarters, dimes, nickels, or pennies required to make 96 cents is 3 quarters, 2 dimes and 1 penny
Note the spelling of penny here.
   *
   * */
public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalPennies = in.nextInt();
        int quarters;
        int nickels;
        int dimes;

        quarters = changePennies(totalPennies, 25);
        totalPennies = totalPennies - (quarters * 25);
        dimes = changePennies(totalPennies, 10);
        totalPennies = totalPennies - (dimes * 10);
        nickels = changePennies(totalPennies , 5);
        totalPennies = totalPennies - (nickels * 5);

        if(quarters > 0) {
            System.out.println(quarters + (quarters == 1 ? " quarter" : " quarters"));
        }
        if(dimes > 0) {
            System.out.println(dimes + (dimes == 1 ? " dime" : " dimes"));
        }

        if(nickels > 0) {
            System.out.println(nickels + (nickels == 1 ? " nickel" : " nickels"));
        }
        if(totalPennies > 0) {
            System.out.println(totalPennies + (totalPennies == 1 ? " penny" : " pennies"));
        }

    }

    private static int changePennies(int total, int coin){

        if(total < coin){
            return 0;
        }

        return total/coin;
    }


}
