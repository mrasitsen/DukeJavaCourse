import java.util.*;
import java.io.*;

public class CharacterInPlay {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreq;

    public CharacterInPlay(){
        myWords = new ArrayList<>();
        myFreq = new ArrayList<>();
    }

    private void update(String person){
        int index = myWords.indexOf(person);
        if (index == -1){
            myWords.add(person);
            myFreq.add(1);
        }else{
            int value = myFreq.get(index);
            myFreq.set(index, value+1);
        }
    }

    private void findAllCharacters(File f) throws FileNotFoundException {
        //List<String> line;
        myWords.clear();
        myFreq.clear();
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String person = "";
            if (line.contains(".")) {
                String[] tempLine = line.split("\\s+");
                for (int i=0; i<tempLine.length; i++) {
                    if (tempLine[i].contains(".")){
                        String lastWord = tempLine[i];
                        lastWord = lastWord.substring(0,lastWord.length()-1);
                        person += lastWord;
                        break;
                    }else{
                        person += tempLine[i] + " ";
                    }

                }
                update(person);
            }
        }
    }


    private void charactersWithNumParts(int number1, int number2){
        for (int i=0; i<myFreq.size(); i++){
            if (myFreq.get(i) >= number1 && myFreq.get(i) <= number2){
                System.out.println(myWords.get(i)+" "+myFreq.get(i));
            }
        }
    }

    private void charactersMostSpeaking(){
        int max = 0;
        int maxIndex = 0;
        for (int i=0; i<myFreq.size(); i++){
            if (myFreq.get(i) > max){
                max = myFreq.get(i);
                maxIndex = i;
            }
        }
        System.out.println("The carachter with most speaking part is"+myWords.get(maxIndex)
                +" : "+myFreq.get(maxIndex));
    }

    private void test() throws FileNotFoundException{
        File f = new File("data/LikeIt.txt");
        findAllCharacters(f);
        charactersWithNumParts(10, 15);
        //charactersMostSpeaking();
    }


    public static void main(String[] args) throws FileNotFoundException{
        CharacterInPlay ins = new CharacterInPlay();
        ins.test();
    }
}
