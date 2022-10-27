// Author : Amit Dave
import java.io.File;
import java.util.Scanner;
import java.io.*;


public class Urinals{
    Boolean goodString(String str)
    {
        int len = str.length();
        for(int i=1; i<len; i++)
        {
            if(str.charAt(i)=='1' && str.charAt(i-1)=='1')
            {
                return false;
            }

        }
        return true;
    }
    int countUrinals(String str)
    {   int count=0;
        int len = str.length();
        if(!this.goodString(str))
            return -1;

            for(int i=0; i<len; i++)
            {
               if(str.charAt(i)=='0')
               {
                   if((i-1<0 || str.charAt(i-1)=='0') && (i+1>=len || str.charAt(i+1)=='0'))
                   {
                       count++;
                       i++;
                   }
               }
            }
        return count;

    }
    void readFile()
    {
        BufferedReader reader;
        try {
            File file = new File("src/urinal.dat");
            Scanner scr = new Scanner(file);
            while (scr.hasNextLine()) {
                String line = scr.nextLine();
                System.out.println(this.countUrinals(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Urinals obj = new Urinals();
        obj.readFile();
    }
}