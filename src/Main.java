import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        baseballGame();
    }

    static void baseballGame () {
        Player player = new Player();
        Controller control = new Controller();

        while (!player.status) {
            ArrayList<Integer> randomNumber = control.randomNum();

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