// Author : Amit Dave
package ICA8;
import java.io.File;
import java.util.Scanner;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class urinals{
    public static Boolean goodString(String str)
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
    public static int countUrinals(String str)
    {   int count=0;
        int len = str.length();
        if(!goodString(str))
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
    String getOutputFileName()
    {

        String filename = "rule.txt";
        int count=0;
        File file = new File(filename);

        while(true)
        {
            if(file.exists())
            {
                count++;
                filename = filename.substring(0,8) + count + ".txt";
                file = new File(filename);
            }
            else
            {
                break;
            }
        }
        return filename;
    }
    public static void writeToFile(int a, String filename)
    {
        try
        {

            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Integer y = a;
            bw.write(y.toString());
            bw.newLine();
            bw.close();

        }
        catch(IOException e)
        {
            System.out.println("I/O Exception!");
        }
    }
    void readFile(String filename)
    {
        String f =  filename;
        try {
            File file = new File(f);
            Scanner scr = new Scanner(file);
            String str = this.getOutputFileName();
            while (scr.hasNextLine()) {
                String line = scr.nextLine();
                int a = this.countUrinals(line);
                writeToFile(a,str);
            }
        } catch (IOException e) {
            System.out.println("Could not read file!");
        }
    }

    public static void main(String[] args) {
        urinals obj = new urinals();
        System.out.println("Do you want to import inputs from a file or by console?");
        System.out.println("1. File");
        System.out.println("2. Console");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
            {
                System.out.println("Enter name of the input file : ");
                String str = sc.next();
                obj.readFile(str);
                break;
            }
            case 2:
            {
                String s;
                char c='N';
                String str = obj.getOutputFileName();
                do {
                    System.out.println("Enter String : ");
                    s = sc.next();
                    int ans = obj.countUrinals(s);
                    obj.writeToFile(ans,str);
                    System.out.println("Continue input (Y/N)?");
                    c = sc.next().charAt(0);
                }while(c=='Y');
            }

        }
    }
}