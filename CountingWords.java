import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class CountingWords {

    public String[] getCommon() throws FileNotFoundException{
        File f = new File("data/common.txt");
        Scanner sc = new Scanner(f);
        String[] common = new String[20];
        for (int i=0; i< common.length; i++){
            common[i] = sc.next();
        }
        return common;
    }

    public int indexOf(String[] common, String word){
        for (int i=0; i<common.length; i++) {
            if (word.equals(common[i])) {
                return i;
            }
        }
        return -1;
    }


    public void countWords(Scanner sc, String[] common, int[] count ) {
        while(sc.hasNext()){
            String word = sc.next();
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if (index != -1){
                count[index] += 1;
            }
        }

    }


    public void countShakespeare() throws FileNotFoundException {
        String[] plays = {"caesar.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt", "errors.txt"};

        String[] common = getCommon();
        int[] counts = new int[common.length];
        for (String play : plays) {
            File f = new File("data/" + play);
            Scanner sc = new Scanner(f);
            countWords(sc, common, counts);
            System.out.println("Done with " + f.getName());
        }


        for (int k = 0; k < common.length; k++) {
            System.out.println(common[k] + " : " + counts[k]);
        }

    }

    public void test() throws FileNotFoundException{
        countShakespeare();
    }


    public static void main(String[] args) throws FileNotFoundException{
        CountingWords var = new CountingWords();
        var.test();
    }
}
