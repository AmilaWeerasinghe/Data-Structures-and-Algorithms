
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<conio.h>

//first define the size of the number if NODEss
#define NODEs 7



//hardcode the matrix representation of your graph
int graph[NODEs][NODEs] = {
   {0, -1, -1, 0,0,0,0},
   {-1, 0, 0, -1,1,0,-1},
   {-1, 0, 0, 0,0,1,0},
   {0, 1, 0, 0,1,-1,1},
   {0, -1, 0, -1,0,0,1},
   {0, 0, -1, 1,0,0,0},
   {0, 1, 0, -1,-1,0,0}

};

int result[NODEs][NODEs];

void transClosureGraph() {
   int i,j,k=0;
   for(i = 0; i<NODEs; i++)
      for( j = 0; j<NODEs; j++)
         result[i][j] = graph[i][j];    //initially copy the graph to the result matrix
   for( k = 0; k<NODEs; k++)
      for( i = 0; i<NODEs; i++)
         for( j = 0; j<NODEs; j++)
            result[i][j] = result[i][j] || (result[i][k] && result[k][j]);
   for( i = 0; i<NODEs; i++) {          //print the result matrix
      for( j = 0; j<NODEs; j++)
         if(i==j){
            result[i][j]=1;//let diagonal to be 1 
            printf("%d ",result[i][j] );
         }
         else if(result[i][j]==1){
            printf("%d ",result[i][j] );//else print result


         }
         else{
            result[i][j]=0;
         printf("%d ",result[i][j] );//else print result
      }
        
      printf("\n");
   }
}


//call main program
int main() {
   transClosureGraph();
}