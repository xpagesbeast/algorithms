import java.util.Scanner;

public class Solution {
    static int numVertices = 5;
    static int inf = 10000;
    static int distance[][] = new int[numVertices][numVertices];

    static int map[][]= new int[numVertices][numVertices];
    static StringBuffer buffer = null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        loadMatrix(true);

        for(int k=0; k<numVertices; k++) {
            for (int row = 0; row < numVertices; row++) {
                for (int col = 0; col < numVertices; col++) {
                    if(distance[row][k] + distance[k][col] < distance[row][col]) {
                        distance[row][col] = distance[row][k] + distance[k][col];
                        map[row][col] = k+1;
                    }

                }
            }
        }

        //print matrix
        for (int row = 0; row < numVertices; row++) {
            for (int col = 0; col < numVertices; col++) {
                if (distance[row][col] >= inf) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[row][col] + " ");
                }
            }
            System.out.println();
        }

        //print map
       // for(int verticy =1; verticy<=numVertices; verticy++) {


            for (int verticy = 0; verticy < numVertices; verticy++) {

                for (int col = 0; col < numVertices; col++) {
                    if (map[verticy][col] == -1) {

                        System.out.println("V" + (verticy + 1) +" V"+(col+1));
                    } else {
                        buffer = new StringBuffer();
                        buffer.append("V" + (verticy + 1) + " ");
                        //System.out.print(" V" + (verticy + 1) + " ");
                        printPath((map[verticy][col] - 1), col);
                        //System.out.println(" V" + (col + 1));
                        buffer.append(" V" + (col + 1) + " ");
                        System.out.println(buffer.toString().replace("  "," "));
                    }

                }

            }
       // }
    }

    private static void printPath(int row, int col){

        if (map[row][col] == -1) {
            buffer.append("V" + (row+1) + " ");
            //System.out.print("V" + (row+1) + " ");
            return;
        }
        buffer.append("V" + (map[row][col]+1)+" ");
        //System.out.print("V" + (map[row][col]+1)+" ");
        printPath((map[row][col]-1),col);


    }

    private static void loadMatrix(boolean useInputStream){
        if(useInputStream){
            Scanner in = new Scanner(System.in);
            numVertices = in.nextInt();
            distance = new int[numVertices][numVertices];
            for(int i=0;i<numVertices;i++){
                for(int j=0;j<numVertices;j++){
                    distance[i][j] = in.nextInt();
                }
            }
        }else {
            distance[0][0] = 0;
            distance[0][1] = inf;
            distance[0][2] = 15;
            distance[0][3] = inf;
            distance[0][4] = inf;

            distance[1][0] = 24;
            distance[1][1] = 0;
            distance[1][2] = 12;
            distance[1][3] = inf;
            distance[1][4] = 19;

            distance[2][0] = inf;
            distance[2][1] = 31;
            distance[2][2] = 0;
            distance[2][3] = 14;
            distance[2][4] = 73;

            distance[3][0] = inf;
            distance[3][1] = inf;
            distance[3][2] = inf;
            distance[3][3] = 0;
            distance[3][4] = 55;

            distance[4][0] = 20;
            distance[4][1] = 9;
            distance[4][2] = 23;
            distance[4][3] = inf;
            distance[4][4] = 0;
        }

        //initialize map
        for (int row=0; row < numVertices; row++) {
            for (int col = 0; col < numVertices; col++) {
                map[row][col] = -1;
            }
        }
    }

}
