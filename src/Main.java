import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        baseballGame();
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

    static void baseballGame () {
        Player player = new Player();
        Controller control = new Controller();

        while (!player.status) {
            ArrayList<Integer> randomNumber = randomNum();

            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.print("숫자를 입력해주세요 : ");
                player.number = sc.nextLine();

                if (!control.inputCheck(player.number)) {
                    System.out.println("형식에 맞지 않는 입력입니다. 다시입력해 주시기 바랍니다.");
                    continue;
                }

                int[] result = control.strikeNum(randomNumber, control.inputNum(player.number));

                if (control.printResult(result)) {
                    int number = control.inputNumber();
                    if (number == 2) player.status = true;
                    break;
                }
            }
        }
    }
}