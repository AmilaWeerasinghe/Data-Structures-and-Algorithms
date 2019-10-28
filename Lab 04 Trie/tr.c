#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#include<time.h>

//this method can be used to convert index into acharacter easily
#define INDEX_TO_CHAR(c) ((int)c + (int)'a')

//define structure 
typedef struct trienode{ 
	//struct trienode *parent ;//pointer to parent
	//char letter;//to store data in the node
	struct trienode  *child [26];//pointers to maximum sjould hold 26 char (alphabet)
	bool isEnd;//to mark if the node is a leaf

 }TrieNode;


//methods
 TrieNode* createNode();
 void insertWord();
  void printSuggestions();

//lets create a method to create a node
 TrieNode* createNode(){
 	TrieNode* newNode=NULL;
  newNode=(TrieNode *) malloc (sizeof(TrieNode));//allocate memory create a node pointer
 	//newNode->letter='#';//assign letter
 
if(newNode){
 	int i;
  //lets claer all child nodes of the node
  newNode->isEnd=false;
 	for( i=0;i<26;i++){
 		newNode->child[i]=NULL;
 	}
//now we have a node with 26 childs associated with it
}

return newNode;
 }




//insert method
void insertNode(TrieNode* root,char* word){
  int len=strlen(word);
	int i,childIndex;
	//TrieNode* node=(TrieNode*)malloc(sizeof(TrieNode));//allocate memory create a node pointer;
	TrieNode* currentNode = root;//assign the root newNode pointer
	
	//printf("%s",word);
	for(i=0;i<strlen(word);i++){
		
		//childIndex = getCharIndex(word[i]);
		childIndex=word[i]-'a';//only 26 childs take its int val
		//printf("%d\n",childIndex);
		if(!(currentNode->child[childIndex])) {
			currentNode->child[childIndex] = createNode();//create a new node
            //newNode->child[childIndex]->letter = word[i];
        }
		currentNode = currentNode->child[childIndex];
       }
      currentNode->isEnd = true;

}

//print method
char suggestW[25];
char tmp[25];
int size = 0;

void printSuggestions(TrieNode *t){

   int i=0;
    if(t->isEnd) {
        tmp[size] = '\0';
        printf("Suggestion : %s%s\n", suggestW,tmp);
    }
    for(i=0;i<26;i++){
        if(t->child[i]){
          //we have to convert the index to a character
            tmp[size] = (char) INDEX_TO_CHAR(i);
            size++;
            printSuggestions(t->child[i]);
            size--;
        }
    }

}

bool findSuggestions(TrieNode *root,const  char *word)
{
  
    int i,count=0;
    int len = strlen(word);
    int index;
    TrieNode *t = root;
 
    for (i = 0; i < len; i++){
    
        index = word[i]- 'a';
 
        if (!t->child[index])
            return false;

        suggestW[count] = INDEX_TO_CHAR(index);
        count++;
 
        t = t->child[index];
    }

    suggestW[count] = '\0';
    printSuggestions(t);


    return (t != NULL && t->isEnd);
}



//driver programme
   int main(int argc, char *argv[]){
    char fileName[100];
   	char word[100];//array ro hold a word
   	if(argc!=2){
   		printf("Wrong input length: Input example: Trie <wordlist10000.txt>");
   	}
   	else{
   		printf("Corret input length\n");
   		printf("file name = %s\n",argv[1]);
      //take user input file name
   		//fileName=argv[1];
   		//char fileName[100]="wordlist70000.txt";
   		//printf("FileName = %s\n",fileName);

   		//read the file 
   		FILE *fp = fopen(argv[1],"r");
    if (fp == NULL)
    {
        printf("Unable to open the file");
        exit(1);
    }

    TrieNode* root = createNode();//create the root node with '/' as data
    //printf("%s",root->letter);
    clock_t start = clock();
    while(!feof(fp)){
        fscanf(fp,"%s",word);
        int j = 0;
        while(word[j]){
            if(isupper(word[j])) word[j] = tolower(word[j]);
            j++;
        }

        
        insertNode(root, word); // inset to the trie word by word
        
    }
    clock_t end = clock();
    double mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
    printf("time taken to store the data in micro sec:\n");
    printf("%f\n",mseconds);


  fclose(fp);
    
    //successfully inserted now we need to find nd print suggestons
  char key[70];//to store input from user

  while(1){

    printf("Tyoe a word  to search :");
    scanf("%s",key);
    printf(" ");
        start = clock();
    findSuggestions(root ,key);
        end = clock();
        mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
        printf("time taken to retrieve the data in micro seconds:\n");
        printf("%f\n",mseconds);
    printf(" ");
    


  }



   	}
   	return 0;
}