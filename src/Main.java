import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> randomNumber = randomNum();
    }

    static ArrayList<Integer> randomNum() {
        Random rd = new Random();
        ArrayList<Integer> numberList =  new ArrayList<>();
        int cnt = 0;

        while(cnt < 3) {
            int number = rd.nextInt(9) + 1;
            if (!numberList.contains(number)) {
                numberList.add(number);
                cnt++;
            }
        }

        return numberList;
    }


}