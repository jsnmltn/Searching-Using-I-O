/*
 * written by Jason Milton
 */
import java.io.*;
import java.util.Scanner;

public class FileSearcher {

public static String uChoice;
public static String title;
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);

        System.out.println("""
        	Welcome to Word Searcher:
        	
        	I will demonstrate how easy it is to search for instances of a word or phrase
        	
        	in a document and display the results!""");
            System.out.println("************************************");

            System.out.println("Select the document for me to scan and search from the following selections below:");
            System.out.println("""
            	Enter '1' to search the \"2023 State of the Uninon Adress\".
            	
            	Enter '2' to search MLK JR's \"I have a Dream\" speach.
            	
            	Enter '3' to search JFK's \"Ask not what your Country can do for you\" speach """);

                String choice = key.next(); 
                switch(choice){
                case  "1":
                    choice = "./StateOfTheUnion.txt";
                    FileSearcher.title = "2023 State Of the Uninion Adress";
                    break;
                case "2":
                    choice = "./MLK_Dream.txt";
                    FileSearcher.title = "I Have a Dream Speech";
                    break;
                case "3":
                    choice = "./JFK_MoonSpeech.txt";
                    FileSearcher.title = "JFK Address at Rice University  \" Moon Speech\" ";
                    break;
                default:
                    choice = "./StateOfTheUnion.txt";
                    FileSearcher.title = "2023 State Of the Uninion Adress";
                } FileSearcher.uChoice = choice;
            
            System.out.println("Excellent choice!\n"  
            + "\nEnter the word you would like for me to search for in the "+FileSearcher.title);
            System.out.println();
            String userWord = key.next();
            int count = FileSearcher.lookForWord(userWord);
            System.out.println();
            System.out.println("The word "+userWord+" appears "+count+" times");
            key.close();
    }

        public static int lookForWord(String userWord)
        {
            if(userWord == null)
                return 0;

            int ret = 0;

            try{
            Scanner fileScanner = new Scanner(new File(FileSearcher.uChoice));

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
