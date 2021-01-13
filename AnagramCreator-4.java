import java.net.*;
import java.util.Scanner;
import java.util.Arrays;

public class AnagramCreator
{
    private static int ct = 0; 
    private static String inputResult = "none";
    public static void main (String[] args)
    {
        try{
            Scanner input = new Scanner(System.in); 
            System.out.println("Please enter a word to find its anagrams!");
            inputResult = input.nextLine();  
            URL url = new URL("https://www.wordgamedictionary.com/enable/download/enable.txt"); 
            Scanner sc = new Scanner(url.openStream());
            char[] arr = inputResult.toCharArray(); 
            while(sc.hasNext())    
            {   
                String fromFileNext = sc.next();  
                char[] arrTwo = fromFileNext.toCharArray(); 
                if (arr.length == arrTwo.length)   
                { Arrays.sort(arr);   
                  Arrays.sort(arrTwo); 
                  for(int i = 0; i < arrTwo.length; i++)  
                  {                                       
                      if (arr[i] == arrTwo[i])    
                      {
                          ct++;                   
                      }
                  }
                }   
                if (ct == arrTwo.length){   
                    System.out.println(fromFileNext); 
                }
                ct = 0;  
        }
       sc.close();     
    }
        catch(Exception e) 
        {System.out.println(e);
        }
    }
}
