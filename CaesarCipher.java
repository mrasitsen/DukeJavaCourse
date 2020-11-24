/*CeaserCipher enrypt program
* this program runs with 1 key or 2 keys
* also this program is useful to decryt messages
* */


public class CaesarCipher {
    static final String constantAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String builder(String alphabet, String input){
        String text = input.toUpperCase();
        int size = input.length();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<size; i++){
            char currLetter = text.charAt(i);
            if (currLetter == ' ') {
                result.append(' ');
                continue;
            }
            int currIndex = constantAlphabet.indexOf(currLetter);
            if (currIndex == -1) {
                result.append(currLetter);
                continue;
            }
            if (Character.isLowerCase(input.charAt(i))) {
                char newLetter = alphabet.charAt(currIndex);
                newLetter = Character.toLowerCase(newLetter);
                result.append(newLetter);
                continue;
            }
            result.append(alphabet.charAt(currIndex));
        }
        return result.toString();
    }

    public static String encrypt(String input, int key){
        String newAlphabet = constantAlphabet.substring(key) + constantAlphabet.substring(0, key);
        return builder(newAlphabet, input);
    }

    public static String encryptTwoKeys(String input, int key1, int key2) {
        String alphabet;
        String newAlphabet1 = constantAlphabet.substring(key1) + constantAlphabet.substring(0, key1);
        String newAlphabet2 = constantAlphabet.substring(key2) + constantAlphabet.substring(0, key2);
        String text = input.toUpperCase();
        int size = input.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                alphabet = newAlphabet1;
            } else {
                alphabet = newAlphabet2;
            }
            char currLetter = text.charAt(i);
            if (currLetter == ' ') {
                result.append(' ');
                continue;
            }
            int currIndex = constantAlphabet.indexOf(currLetter);
            if (currIndex == -1) {
                result.append(currLetter);
                continue;
            }
            if (Character.isLowerCase(input.charAt(i))) {
                char newLetter = alphabet.charAt(currIndex);
                newLetter = Character.toLowerCase(newLetter);
                result.append(newLetter);
                continue;
            }
            result.append(alphabet.charAt(currIndex));
        }
        return result.toString();
    }



    public void test(){
        String text = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        int key1 = 12;
        int key2 = 2;
        System.out.println("Old text : "+text);
        text = encryptTwoKeys(text, key1, key2);
        System.out.print("New text : "+text);
//        text =  encrypt(text, key1);
//        System.out.println(text);
    }

    public static void main(String[] args){
        CaesarCipher var = new CaesarCipher();
        var.test();

    }
}
