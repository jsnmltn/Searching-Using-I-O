/*
 * written by Jason Milton
 */
import java.io.*;
import java.util.Scanner;

public class FileSearcher {
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);

        System.out.println("Welcome to Word Searcher:\n"
            + "\nI will demonstrate how easy it is to search for instances of a word\n"
            + "\n a document and display the results!");
            System.out.println("************************************");

            System.out.println("Enter a word I will search for instances of it in this year's 'State of the Union'");

            String userWord = key.nextLine();
            int count = lookForWord(userWord);
            System.out.println("The word "+userWord+" appears "+count+" times");
            key.close();
    }

        public static int lookForWord(String userWord)
        {
            if(userWord == null)
                return 0;

            int ret = 0;

            try{
            Scanner fileScanner = new Scanner(new File("./StateOfTheUnion.txt"));

            while(fileScanner.hasNext())
            {
                String next = fileScanner.next();
                if(next.toUpperCase().contains(userWord.toUpperCase()))
                    ret ++;       
            } 
            fileScanner.close();
            }catch(Exception e)
                {
                    e.printStackTrace();
                }
            return ret;
        }
}
