public class wordPlay {    public static boolean isVowel(char ch){        ch = Character.toUpperCase(ch);        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';    }    public static String replaceVowels(String phrase, char ch){        int size = phrase.length();        for(int i=0; i<size; i++){            if(isVowel(phrase.charAt(i))){                phrase = phrase.replace(phrase.charAt(i), ch);            }        }        return phrase;    }    public static String exchange(String text, int index, char newChar){        return text.substring(0, index) + newChar + text.substring(index+1);    }    public static String emphasize(String phrase, char ch){        ch = Character.toLowerCase(ch);        int size = phrase.length();        for(int i=0; i<size; i++){            char currChar = phrase.charAt(i);            currChar = Character.toLowerCase(currChar);            if(currChar == ch) {//                System.out.println(i);                if (i % 2 == 0){                    phrase = exchange(phrase, i, '*');                } else {                    phrase = exchange(phrase, i, '+');                }            }        }        return phrase;    }    public static void test(){        String text = "merhabalar aq";        char ch = 'i';        String newText = replaceVowels(text, ch);//        System.out.println("The word "+text+" is now "+newText);        System.out.println("The word now become " + emphasize("Mary Bella Abracadabra", 'a'));//        text = exchange(text, 3, 'x');//        System.out.println(text);    }    public static void main(String[] args){//        wordPlay var = new wordPlay();//        var.test();        test();    }}