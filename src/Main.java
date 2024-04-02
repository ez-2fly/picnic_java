import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = readFile("src/input.txt");
        System.out.println("Самое длинное слово: " + findTheLongestWord(words));
        System.out.println("Количество слов в файле: " + words.length);
        printMap(findRepetitions(words));
    }
    static String[] readFile(String path){
        File file = new File(path);
        try(FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            line = line.trim().replaceAll(" +", " ");
            line = line.toLowerCase();
            return line.split(" ");
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }

    static String findTheLongestWord(String[] words){
        int max = 0;
        String theLongestWord = "";
        for (String word : words){
            if (word.length() > max){
                max = word.length();
                theLongestWord = word;
            }
        }
        return theLongestWord;
    }

    static HashMap<String, Integer> findRepetitions(String[] words){
        HashMap<String, Integer> repetitions = new HashMap<>();
        for (String word : words){
            if (!repetitions.containsKey(word)) repetitions.put(word, 1);
            else{
                repetitions.replace(word, repetitions.get(word) + 1);
            }
        }
        return repetitions;
    }

    static void printMap(HashMap<String, Integer> repetitions){
        for (Map.Entry<String, Integer> item : repetitions.entrySet()){
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}