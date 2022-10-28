import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ICA8.urinals.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import ICA8.urinals;

public class urinalsTest {
    @Test
    void checkInputFileExists() {
        File file = new File("src/urinal.dat");
        assertTrue(file.exists());
    }

    @Test
    void checkInputFileEmpty()
    {
        File file = new File("src/urinal.dat");
        assertTrue(file.length()!=0);
    }
    @Test
    void checkOutputFileEmpty()
    {
        File file = new File("src/rule.txt");
        assertTrue(file.length()!=0);
    }
    @Test
    void checkOutputFileExists()
    {
        File file = new File("src/rule.txt");
        assertTrue(file.exists());
    }
    @Test
    void checkNumberFormatException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            writeToFile(Integer.parseInt("One"),"src/rule.txt");
        });
    }
    @Test
    void checkDuplicateFiles(){
        File directoryPath = new File("src");
        //List of all files and directories
        String contents[] = directoryPath.list();
        for(int i=0; i<contents.length; i++) {
            for(int j=i+1; j<contents.length; j++)
            {
                if(contents[i] == contents[j] && contents[i].equals("urinal.dat")==true)
                {
                    System.out.println("Duplicate files present!");
                    assertTrue(false);
                }
            }
        }

    }
    @Test
    void checkBadFileName(){
        File directoryPath = new File("src");
        //List of all files and directories
        String contents[] = directoryPath.list();
        for(int i=0; i<contents.length; i++) {
            if(contents[i].contains("urinal") && contents[i].contains("dat") && contents[i].equals("urinal.dat")==false)
            {
                System.out.println("Bad File Name! It should be urinal.dat , or there is a duplicate .dat file in the folder");
                assertTrue(false);
            }
        }

    }

    @Test
    void checkallGoodStrings_IOException()
    {

        try {
            File file = new File("src/urinal.dat");
            List<Boolean> list=new ArrayList<Boolean>();
            List<Boolean> output = new ArrayList<>(List.of(true,true,true,true,true,false));
            Scanner scr = new Scanner(file);
            while (scr.hasNextLine()) {
                String line = scr.nextLine();
                Boolean res = goodString(line);
                list.add(res);
            }
            assertTrue(output.equals(list));
        } catch (IOException e) {
           System.out.println("Input/Output Exception!");
        }
    }
    @Test
    void checkallUrinals_IOException()
    {

        try {
            File file = new File("src/urinal.dat");
            List<Integer> list=new ArrayList<Integer>();
            List<Integer> output = new ArrayList<>(List.of(1,0,3,2,1,-1));
            Scanner scr = new Scanner(file);
            while (scr.hasNextLine()) {
                String line = scr.nextLine();
                int res = countUrinals(line);
                list.add(res);
            }
            assertTrue(output.equals(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
