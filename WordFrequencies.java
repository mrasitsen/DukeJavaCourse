import java.io.*;
import java.util.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    private void findUniqe(File f) throws FileNotFoundException {
        String word;
        myFreqs.clear();
        myWords.clear();
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            word  = sc.next();
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
        findIndexOfMax();
    }

    private void findIndexOfMax(){
        int max = 0;
        int maxIndex = 0;
        for (int i=0; i<myFreqs.size(); i++) {
            if (myFreqs.get(i)>max){
                max = myFreqs.get(i);
                maxIndex=i;
            }
        }
        System.out.println("Number of uniqe words : "+myWords.size());
        System.out.println("Most common word is : "+myWords.get(maxIndex)+" "+myFreqs.get(maxIndex));
    }

    private void test() throws FileNotFoundException {
        File f = new File("data/LikeIt.txt");
        findUniqe(f);
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordFrequencies wf = new WordFrequencies();
        wf.test();
    }
}
