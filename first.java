import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class first {
    public static void main (String[] args) throws IOException{
        Console console = System.console();
        File file = new File("C://Users//Юлия//Desktop//жаба//Лаба1", "Alice.txt");

        if(!file.exists()){
            console.printf("Error. File doesn`t exist!");
        }

        //Scanner sc1 = new Scanner(file);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;

        List<String> words = new ArrayList<String>();
        
        while((str=br.readLine())!=null){
           String line = str.replaceAll("\\p{Punct}|\\d", " ");

            words.addAll(Arrays.asList(line.split(" ")));
        }
        /*while(sc1.hasNextLine()){
            String line = sc1.nextLine();
            line = line.replaceAll("\\p{Punct}|\\d", " ");

            words.addAll(Arrays.asList(line.split(" ")));
        }
        sc1.close();*/
        for(int i=words.size()-1; i >= 0; i--)
        {
            if (words.get(i).length()==0){
                words.remove(i);
            }
            else if (words.get(i).length()>30){
                words.set(i, words.get(i).substring(0, 30));
            }
        }

         HashSet<String> wordsWithoutDublicates = new HashSet<>(words);

         for (String w: wordsWithoutDublicates){
            console.printf(w + " - " + Collections.frequency(words, w) + "\n");
        } 
    }
}