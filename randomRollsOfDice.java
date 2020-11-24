import java.util.Random;

/*counts the random roll dice numbers*/

public class randomRollsOfDice {

    public static void roll(){
        int total = 0;
        int[] count = new int[12];
        Random r = new Random();
        for (int i=0; i<10000; i++){
            int dice1 = r.nextInt(7-1)+1;
            int dice2 = r.nextInt(7-1)+1;
            int index = dice1+dice2;
            count[index - 1] += 1;
            total++;

        }

        for (int i=0; i<12; i++){
            System.out.println((i+1)+" : "+count[i]);
        }
        System.out.println("Total : "+total);
    }

    public static void test(){
        roll();
    }

    public static void main(String[] args){
        test();
    }
}
