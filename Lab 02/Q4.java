/*
* E/15/385
* Lab 02
* Dynamic Programming
* */
class Q4 {
    static int [][] cost = {{0, 3, 12, 23, 41}, // cost from 0
            {0, 0,  2,  4, 34}, // cost from 1
            {0, 0,  0,  12, 3}, // cost from 2
            {0, 0,  0,  0, 12}, // cost from 3
            {0, 0,  0,  0,  0}  // cost from 4
    };

    static int iMax = 5;
    static int jMax = 5;

    // Just for testing, min cost from 0 to 4 should be 8.
    static int answer = 8;

    //recursive function to find the minimum cost from i to j
    static int LargestNum=Integer.MAX_VALUE;//largest possible integer value

    public static int minCost(int i, int j) {

        {
            // minimum[i] stores minimum cost to reach station i
            // from station 0.
            int [] minimum = new int[j+1-i];//size of the array needed
            for (int k=0; k<j+1-i; k++) {
                minimum[k] = LargestNum;//initialize array with larget possible value so any other cost is smaller than this
            }
                minimum[0] = 0;//initialize first val with zero


            // traverse through the stations and fing if an intermediate station gives loswet cost
            for (int m=i; m<j; m++) {
                for (int n=m+1 ; n <j+1; n++) {
                    if (minimum[n - i] > minimum[m - i] + cost[m][n]) {
                        minimum[n - i] = minimum[m - i] + cost[m][n];
                    }
                }

            }

            return minimum[j-i];
        }
    }

    public static void main(String [] args) {
        int r = minCost(0,4);
        //System.out.println("Minimum cost from "+start+ " from "+end+" = "+ r);
        if(r == answer)
            System.out.println("Your implementation might be correct");
        else
            System.out.println("Too bad. Try again (" + r + ")");
    }
}