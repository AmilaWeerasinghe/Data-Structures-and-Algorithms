/*
* E/15/385
* Lab 02
* Dynamic Programming
* */
class ex {
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


    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    //recursive function to find the minimum cost from i to j
    /* Returns cost of minimum cost path
    from (0,0) to (m, n) in mat[R][C]*/
    static int minCost(int cost[][], int m,
                       int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] +
                    min( minCost(cost, m-1, n-1),
                            minCost(cost, m-1, n),
                            minCost(cost, m, n-1) );
    }

    public static void main(String [] args) {
        int start=2;
        int end =4;
        int r = minCost(0,4);
        System.out.println("Minimum cost from "+start+ " from "+end+" = "+ r);
        if(r == answer)
            System.out.println("Your implementation might be correct");
        else
            System.out.println("Too bad. Try again (" + r + ")");
    }
}