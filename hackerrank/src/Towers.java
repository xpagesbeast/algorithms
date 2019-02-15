public class Towers {
    /*


    Three posts, three rings on post 1.
    how to move all rings at start to another post.
    conditions, move one ring at a time.
    cannot put a bigger ring on top of smaller'

    I           I       I
    start       aux     end
      1          2       3


     */


    public static void main(String[] args){

    }

    public static void toh(int n, int s, int e , int a){
        if(n==0) return;
        toh(n-1,s,e,a);
        System.out.println("Move from " + n + " " + s );
        toh(n-1,a,e,s);
    }
}
