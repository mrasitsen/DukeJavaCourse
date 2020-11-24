import java.io.*;
import java.util.Scanner;

//program to find most common word lengths

public class wordLengths {

    public static String wordMaker(String word){ //making a word as clear from other objects
        word = word.toLowerCase();
        for (int i=0; i<word.length(); i++){
            if (!Character.isLetter(word.charAt(i))){
                word = word.substring(i+1);
            } else{break;}
        }
        for (int i=1; i<=word.length();){
            int index = word.length()-i;
            if (!Character.isLetter(word.charAt(index))){
                word = word.substring(0, index);
            } else{break;}
        }

        return word;
    }


    public static void howSplitWorks(File f, int[] arr) throws FileNotFoundException{ //seperating the words
        Scanner sc = new Scanner(f);
        while (sc.hasNext()){
            String word = sc.next();
            word = wordMaker(word);
            //System.out.println(word);
            int index = word.length();
            if (index < 30){
                arr[index] += 1;
            }else{
                arr[30] += 1;
            }
        }
        int indexOfMax = 0;
        for (int i=0; i<31; i++){
            System.out.println("length "+i+" : "+arr[i]);
            if (arr[i] > arr[indexOfMax]){
                indexOfMax = i;
            }
        }
        System.out.println(indexOfMax);

    }


    public static void test() throws FileNotFoundException{
        File f = new File("data/manyWords.txt");
        int[] arr = new int[31];
        howSplitWorks(f, arr);

    }


    public static void main(String[] args) throws FileNotFoundException{
        test();
    }
}

