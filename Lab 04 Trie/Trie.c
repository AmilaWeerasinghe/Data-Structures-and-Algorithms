#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#include<time.h>



//define structure 
typedef struct trienode{ 
	//struct trienode *parent ;//pointer to parent
	char letter;//to store data in the node
	struct trienode  *child [26];//pointers to maximum sjould hold 26 char (alphabet)
	bool isEnd;//to mark if the node is a leaf

 }TrieNode;



//lets craete a method to create a node
 TrieNode* createNode(){
 	TrieNode* newNode=NULL;
  newNode=(TrieNode *) malloc (sizeof(TrieNode));//allocate memory create a node pointer
 	newNode->letter='#';//assign letter
 	newNode->isEnd=false;

 	int i;//using this integer lets claer all child nodes of the node
 	for( i=0;i<26;i++){
 		newNode->child[i]=NULL;
 	}
 	//now we have a node with 26 childs associated with it


return newNode;
 }





void insertNode(TrieNode* root,char* word){
	int i,childIndex;
	//TrieNode* node=(TrieNode*)malloc(sizeof(TrieNode));//allocate memory create a node pointer;
	TrieNode* newNode = root;//assign the root newNode pointer
	
	//printf("%s",word);
	for(i=0;i<strlen(word)-1;i++){
		
		//childIndex = getCharIndex(word[i]);
		childIndex=word[i]-'a';//only 26 childs take its int val
		//printf("%d\n",childIndex);
		if(!(newNode->child[childIndex])){
			newNode->child[childIndex] = createNode();//create a new node
            newNode->child[childIndex]->letter = word[i];
        }
		newNode = newNode->child[childIndex];
       }
       newNode->isEnd = true;

}


 TrieNode* createNode();
  void insertWord();
   int printSuggestions();


//driver programme
   int main(int argc, char *argv[]){
   	char word[100];//array ro hold a word
   	if(argc!=2){
   		printf("Wrong input length");
   	}
   	else{
   		printf("Corret input length\n");
   		printf("file name = %s\n",argv[1]);
   		//fileName=argv[1];
   		char fileName[100]="wordlist1000.txt";
   		printf("FileName = %s\n",fileName);

   		//read the file 
   		FILE *fp = fopen(fileName,"r");
    if (fp == NULL)
    {
        printf("Unable to open the file");
        exit(1);
    }
    TrieNode* root = createNode();//create the root node with '/' as data
    //printf("%s",root->letter);
    while(1)
    {
        fgets(word,100,fp);//take 100 cahracter at a time into word array
        //printf("%s\n",word);
        //word by word is sent into the trie
        insertNode(root,word);//insert the word array with the above created root
        if(feof(fp))
            break;
    }
    



   	}
   	return 0;
}