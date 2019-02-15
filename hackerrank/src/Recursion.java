public class Recursion
{

   static String indent = "";   
   static long count = 0;

   public static void main(String[] args)
   {
      count = 0;
      indent ="";
      String possiblePal = "racecar";
      if( isPal(possiblePal) ) 
      {
         System.out.println( possiblePal + " is a palindrome!");
      }
      else
      {
         System.out.println( possiblePal + " is NOT a palindrome!");
      }
      System.out.println( "recursions = " + count );
      
      count  = 0;
      String s1 = "gattagtagttcagtgag";
     String s2 = "ggatgatgatggatcgg";

     // String s1 = "gatta";
     // String s2 = "ggat";

      String s3 = lcs(s1, s2, 0, 0);
      System.out.println( s1 + "\n" + s2 + "\nLCS = " + s3 );
      System.out.println( "recursions = " + count );
      
      count = 0;
      indent ="";
      int s = 10;
      int n = 20;
      System.out.println( "Sum of all values from " + s + " to " + n + " is: " + sum(s, n) );
      System.out.println( "recursions = " + count );

      count = 0;
      indent ="";
      n = 12;
      System.out.println( "fibonacci(" + n + ") is: " + fibonacci(n) );
      System.out.println( "recursions = " + count );
      
      count = 0;
      indent ="";
      n = 12;
      System.out.println( "factorial(" + n + ") is: " + factorial(n) );
      System.out.println( "recursions = " + count );

      count = 0;
      indent ="";
      int r = 2;//16;
      int c = 2;//15;
      System.out.println( "minimum # of shortest paths from " + r + "," + c + " to 0,0 is: " + minPaths(r,c) );
      System.out.println( "recursions = " + count );
      
   }
   /* this is the method the user would call */
   public static boolean isPal(String s)
   {
      return isPal(s, 0, s.length()-1);
   }

   /*
   *  Palidrone:
   *  An interesting problem that can be easily solved using the deque data structure is the classic palindrome problem.
   *  A palindrome is a string that reads the same forward and backward, for example, radar, toot, and madam. We would
   *  like to construct an algorithm to input a string of characters and check whether it is a palindrome.
   *
   *  The solution to this problem will use a deque to store the characters of the string. We will process the string
   *  from left to right and add each character to the rear of the deque. At this point, the deque will be acting very
   *  much like an ordinary queue. However, we can now make use of the dual functionality of the deque.
   *
   *  The front of the deque will hold the first character of the string and the rear of the deque will hold the last
   *  character
   *  Since we can remove both of them directly, we can compare them and continue only if they match. If we can keep
   *  matching first and the last items, we will eventually either run out of characters or be left with a deque of
   *  size 1 depending on whether the length of the original string was even or odd. In either case, the string must
   *  be a palindrome.
   * */
   public static boolean isPal(String s, int start, int end)
   {
      count++;

      //if we are out of characters, must be a palidrone
      if(start >= end){
         return true;
      }

      //if characters match front and back, then check next set.
      if(s.charAt(start) == s.charAt(end)) {
         return isPal(s,start+1,end-1);
      }

      //there was no match
      return false;
   }

   /*
   * Factorial is a basic mathematic function often represented by n! in mathematics, represents the product of all integers less than or equal to the positive integer n. An important function frequently used in combinatorics (permutations & combinations) theory.
For example, 12! can be written as
12! = 1 x 2 x 3 x . . . . x 11 x 12
12! = 479001600
   * */
   public static int factorial(int n)
   {
      indent += "  ";
      System.out.println( indent + "factorial(" + n + ")" );
      //stop and recursion calls go here
      if(n==0){
         return 1;
      }

      if(n==1){
         return 1;
      }

      int retVal = n * factorial(n-1);

      indent = indent.substring(2);
      count++;
      return retVal;
   }

   public static int fibonacci(int n)
   {
      int retVal = 0;
      System.out.println( indent + "fibonacci(" + n + ")" );
      count++;
      indent += "  ";
      //stop and recursion go here
      if(n == 0){
         return 0;
      }

      if(n==1){
         return 1;
      }

      retVal = fibonacci(n-1) + fibonacci(n-2);

      indent = indent.substring(2);
      System.out.println( indent + "returning " + retVal );
      return retVal;
   }
   
   public static int sum(int s, int n)
   {
      int retVal = 0;
      System.out.print( indent + "sum(" + s + ", " + n + ") = " );
      count++;
      indent += "  ";
      //stop and recursion go here
      if(s>n){
         return 0;
      }
      retVal = s + sum(s + 1,n);

      indent = indent.substring(2);
      System.out.println( indent + "returning " + retVal );
      return retVal;
   }
      
   public static long minPaths(int r, int c)
   {
      /* count the number of paths that use the fewest steps to get from 
         location (r,c) to location (0,0).  There is generally more than one */   
      /* use recursion - when is the value 0?  when is it 1? */
      long retVal = 0;
      count = count + 1;

      if(r==0 || c==0){
         System.out.println("(" + r + "," + c +")\n");
         return 1;
      }else{
         System.out.print("(" + r + "," + c +")->");
      }

      retVal = minPaths(r-1,c) + minPaths(r,c-1);

      return retVal;
   }
   
   /* rewrite the lcs method keeping the Strings unchanged 
         use aIdx and bIdx as your starting indices.
         eg. stopping condition is if aIdx >= length of a, etc */ 
   public static String lcs( String a, String b, int aIdx, int bIdx)
   {
      count++;
      if(a.length() == 0 || b.length()==0){
         return "";
      }

      if(aIdx >= a.length()){
         return "";
      }

      if(bIdx >= b.length()){
         return "";
      }

      if(a.charAt(aIdx) == b.charAt(bIdx)){
         return a.charAt(aIdx) + lcs(a,b,aIdx +1,bIdx+1);
      }

      String s1 = lcs(a,b,aIdx,bIdx+1);
      String s2 = lcs(a,b, aIdx+1,bIdx);
      if(s1.length() >= s2.length()){
         return s1;
      }else{
         return s2;
      }

   }
   /* here is the version we worked out in class */
   public static String lcs( String s1, String s2 )
   {  
      /* find the longest common subsequence between char arrays a and b */
      /* aIdx and bIdx are indices into the respective arrays */
      /* what is our stopping condition? */
      /* what if the characters at aIdx and bIdx are the same?  what if they are not? */
      count++;
      if( s1.length() == 0 || s2.length() == 0 )
         return "";
      if( s1.charAt(0) == s2.charAt(0) ) 
      {
         return s1.charAt(0) + lcs( s1.substring(1), s2.substring(1));
      }
      String a = lcs(s1.substring(1), s2);
      String b = lcs(s1, s2.substring(1));
      if( a.length() > b.length() )
      {
         return a;
      }        
      return b;         
   }
}