
/*smart Dcrypt program to solve enrypted messages*/

import java.util.Scanner;

public class smartDecrypter {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static final String frequentAlphabet = "etaoinshrdlcumwfgypbvkxjqz";


    public static int mostFrequentLetter(String text){ //detect most frequent letter in text
        int[] lettersArray = new int[27];
        for (int i=0; i<text.length(); i++){
            char letter = text.charAt(i);
            if(letter == ' '){
                continue;
            }
            int index = alphabet.indexOf(letter);
            if (index == -1){
                continue;
            }
            lettersArray[index] += 1;
        }
        int max = 0;
        int ind = 0;
        for (int i=0; i<lettersArray.length; i++){
            if (lettersArray[i]>max){
                max = lettersArray[i];
                ind = i;
            }
        }
        return ind;
    }

    public static String decrypter(String message, int key){ //decrypt the text
        StringBuilder result = new StringBuilder();
        int decKey = 26-key;
        String decAlphabet = alphabet.substring(decKey) + alphabet.substring(0,decKey);
        for (int i=0; i<message.length(); i++){
            char letter = message.charAt(i);
            if (letter == ' ') {
                result.append(letter);
                continue;
            }
            int indexAlphabet = alphabet.indexOf(letter);
            if (indexAlphabet == -1){
                result.append(letter);
                continue;
            }
            char letterDecAlphabet = decAlphabet.charAt(indexAlphabet);
            result.append(letterDecAlphabet);
        }
        return result.toString();
    }

    public static void detect(String text){ //trys every letter in most frequent letter alphabet.
        text = text.toLowerCase();
        Scanner sc = new Scanner(System.in);
        int indexOfMostFrequentLetter = mostFrequentLetter(text); //x
        for (int i=0; i<frequentAlphabet.length(); i++){
            char targetLetter = frequentAlphabet.charAt(i); //e
            int indexOfTargetLetter = alphabet.indexOf(targetLetter);
            int key = indexOfMostFrequentLetter - indexOfTargetLetter;
            if (key<0){
                key = 26+key;
            }
            System.out.println("Here is the decrypted message : "+decrypter(text, key));
            System.out.println("is it correct (y/n) : ");
            String input = sc.nextLine();
            if (input.equals("y")){
                System.out.println("Congrats, you did brake the code");
                break;
            }
        }
    }

    public static void test(){
        detect("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!");
    }

    public static void main(String[] args){
        test();
    }
}
