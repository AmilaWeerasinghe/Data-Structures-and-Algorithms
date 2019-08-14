import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//a driver program to test my hash table and hash functionality
public class TestHashTable5 extends HashTableImp5
{

    //send to hashtable constructor
    public TestHashTable5(int numOfBuckets){
        super(numOfBuckets);
    }//end of constructor

    public static void main(String[]args){
        //initialize the variables neeeded

        String line="";
        int hashTableSize=0;
        TestHashTable5 hashMap=null;

        //Extracting number of buckets from first argument
        if(args[0].equals("bucket")) {
            hashTableSize = Integer.valueOf(args[1]);
            System.out.println("hashTableSize = " + hashTableSize);
            //implement a hashtbale for that size
            hashMap = new TestHashTable5(hashTableSize);

            String fileName = args[2];
            System.out.println("filename = " + fileName);
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    //Converting all non-alphanumberic characters to whitespace
                    String text = line.replaceAll("\\W", " ");
                    //split lines between whitespaces
                    String tokens[] = text.split("\\s+");
                    for (String s : tokens) {
                        //insert strings to hash table
                        hashMap.insert(s);
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("File does not exists error");
                System.exit(0);
            }
            catch (IOException e)
            {
                System.out.println("File reading failed error");
                System.exit(0);
            }

            //print relavant info of hashtable
            //Print overall information of contents in the hash table and it's distribution
            hashMap.getBucketSize(hashTableSize);
            System.out.println();

            //we need to find reslut of each key using search function in implentation
            try(Scanner keyboard=new Scanner(System.in)) {
                String key="";
                while (!key.equals("exit")) {
                    System.out.println("Enter key :");
                    key = keyboard.nextLine();
                    System.out.println(key + " appeared " + hashMap.search(key) + " times.");

                }
            }

        }
        else{
            System.out.println("Wrong input");
            System.out.println("Sample input: ");
            System.out.println("Java TestHashTable bucket 30[bucket size] sample-text1.txt[file name]");

        }




    }



}