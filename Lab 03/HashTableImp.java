/*********************************************
 * CO322: Data structures and algorithms
 * E/15/385
 * Weerasinghe S.P.A.P.E
 * S I T H.O.F
 * Implementation of the hashTable
 *********************************************/
public class HashTableImp implements HashTable {

    /* Put your code here */
    //we need to define linked list
    private static class nodeList{
        String key;
        int value=0; //number of times the key was inserted
        nodeList next;//pointer to next node in the lists
    }

    public nodeList[] hashTable;//my hashTable is an array of nodes i implemented
    //varaible to count number of times a word occured
    private int count;
    /*When collison occurs pointer can go to
    next node
    * */

    //constructor specify the number of buckets neeeded

    //number of buckets must be given
    public HashTableImp(int numOfBuckets) {
        // create a open hash table with given number of buckets

        hashTable=new nodeList[numOfBuckets];
    }
    //we are supposed to implement a insert function
    //size of the number of buckets should be given by the user
    //lets assign it here later
    //int numOfBuckets=10;

    //then when we know the size we can complete the hashTable

    public void insert (String key){

        //bucket shuld be decided by the hash function

        int bucket= hashFunction(key);//calculate the bucket
        //System.out.println(bucket);
        nodeList list = null;//create a emtynodelist

        try {
            list=hashTable[bucket];// assign the hashlist created earlier
        }
        catch (ArrayIndexOutOfBoundsException e){
            //found while testing
            System.out.println(bucket);
        }



        while(list!=null){
            //search for key in the list
            if(list.key.equals(key))
                break;
            list=list.next;//traverse

        }
        //here either the list is null or we have found the key in list
        if(list!=null){
            //here only we have found the key in the list
            list.value++;//static value of number of times the key entered incremented
        }
        else{
            //list is null
            //not already used
            //add new node and insert key

            nodeList newNode=new nodeList();//construction of new node
            newNode.key=key;
            newNode.value++;//increment the times the key inserted
            newNode.next=hashTable[bucket];//point to the hashtable
            hashTable[bucket]=newNode;
            count++;

        }


    }

    //gain the number of times key appeared(value) associated with a key
    public int search(String key){
        int bucket=hashFunction(key);///gain the bucket val

        //make a pointer to traverse
        nodeList list=hashTable[bucket];//assign the hash table

        while(list!=null){
            if(list.key.equals(key))
                return list.value;//return  num of times key appeared
            list=list.next;//traverse through the list

        }

        //by the end of the list if key not found

        return 0;

    }
/*Given a string a1a2a3 . . . ak, we represent it as �
i aibi, where
b is a base chosen to be larger than the number of characters. We can then feed
this resulting huge integer to our hash function. Typically we do not actually
compute the huge integer directly, but instead compute its remainder mod m,
* */
    private int hashFunction(String key){
        //key is the input here
        int hash=0;

        for(int i=0;i<key.length();i++){
            //use of division is leads to lot of collisons . USe 31 prime number as a multiplier
            hash=(523* hash + key.charAt(i))%hashTable.length;//hash*31+key.charAt(i);//add ascii value of the characters
            //casting is not needed
        }

        return (hash % hashTable.length);//smaller size fixed to fixed to the size of thr hashtable

    }

    //return info of hashtable

    public void getBucketSize(int size)
    {
        int x2=0;
        int sum = 0;
        for(int i=0;i<size;i++)
        {
            int counter=0;
            nodeList list = hashTable[i];
            while(list != null)
            {
                list = list.next;//traverse to see val of key
                counter++;//increment
            }
            sum+=counter;
            x2=x2+(int) Math.pow(counter,2);
            System.out.println((i+1)+":"+counter);
        }
        float avg = (float)(sum/(float)size);
        float var = (float)(x2/size) - (float)(Math.pow(avg, 2));
        System.out.println("Total:"+sum);
        System.out.println("Average:"+avg);
        System.out.println("Standard Deviation:"+Math.sqrt(var));
    }


}// end HashTableImp 
