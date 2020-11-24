import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
this program decrypts two key caesar cipher enryption
it makes the sentence as two different sentence, even letters and odd letters.
then it uses a method in smartDecrypter class, called mostFrequentLetter to detect
most frequent letter. then it takes this letter and assumes it is the first letter in
most frequent english alphabet. for both different text piece, it does the process
then it runs the twoKeysEncrypt method to decryt this message.
 */

public class CeasarBreaker {

    public static void detect(StringBuilder text){

        StringBuilder text1 = new StringBuilder();
        StringBuilder text2 = new StringBuilder();
        for (int i=0; i<text.length(); i++){
            if (i % 2 == 0) {
                text1.append(text.charAt(i));
            } else {
                text2.append(text.charAt(i));
            }
        }

        int indexOfMFGText1 = smartDecrypter.mostFrequentLetter(text1.toString());
        int indexOfMFGText2 = smartDecrypter.mostFrequentLetter(text2.toString());
        for (int i=0; i<smartDecrypter.frequentAlphabet.length(); i++){
            char targetLetter1 = smartDecrypter.frequentAlphabet.charAt(i); //e
            int indexOfTargetLetter1 = smartDecrypter.alphabet.indexOf(targetLetter1);
            int key1 = indexOfMFGText1 - indexOfTargetLetter1;
            if (key1<0){
                key1 = 26+key1;
            }
            for (int k=0; k<smartDecrypter.frequentAlphabet.length(); k++){
                char targetLetter2 = smartDecrypter.frequentAlphabet.charAt(k); //e
                int indexOfTargetLetter2 = smartDecrypter.alphabet.indexOf(targetLetter2);
                int key2 = indexOfMFGText2 - indexOfTargetLetter2;
                if (key2<0) {
                    key2 = 26 + key2;
                }
                int count = 0;
                String result = CaesarCipher.encryptTwoKeys(text.toString(), key1, key2);
                System.out.println((26-key1)+","+(26-key2)); //printing the keys
                for (String word : result.split(" ")){ //just to print first 5 words
                    System.out.print(word+" ");
                    if(count > 4){
                        System.out.println();
                        break;
                    }
                    count++;
                }
//                System.out.println("ans : " + CaesarCipher.encryptTwoKeys(text.toString(), key1, key2));
            }
        }

    }



    public static void test() throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        File f = new File("data/mysteryOfTwoKeysQuiz.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){ //building a string builder
            text.append(sc.next()+" ");
        }
        detect(text);

//        StringBuilder text = new StringBuilder("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
//        detect(text);

    }

    public static void main(String[] args) throws FileNotFoundException {
        test();
    }
}
