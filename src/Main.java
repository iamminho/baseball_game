import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> randomNumber = randomNum();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        baseballGame(tmp);
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


    static boolean inputCheck (String input) {
        String pattern = "^[1-9]*$";
        HashSet<Character> set = new HashSet<>();

        // 글자 수가 3개가 아닐때
        if (input.length() != 3) return false;

        // 글자안에 특수문자, 공백, 0등 1~9의 숫자가 아닐때
        if (!Pattern.matches(pattern, input)) return false;

        // 겹치는 숫자가 있을때
        for (int i = 0; i < input.length(); i++) set.add(input.charAt(i));
        if (set.size() != input.length()) return false;

        return true;
    }

    static ArrayList<Integer> inputNum(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int tmp = input.charAt(i) - '0';
            numbers.add(tmp);
        }

        return numbers;
    }


    static void baseballGame (ArrayList<Integer> randomNumber) {
        boolean stopOrGo = false;

        while (!stopOrGo) {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.print("숫자를 입력해주세요 : ");
                String input = sc.nextLine();

                if (!inputCheck(input)) {
                    System.out.println("형식에 맞지 않는 입력입니다. 다시입력해 주시기 바랍니다.");
                    continue;
                }

                ArrayList<Integer> inputList = inputNum(input);
                int[] result = strikeNum(randomNumber, inputList);

                if (printResult(result)) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int number = sc.nextInt();
                    if (number == 2) stopOrGo = true;
                    break;
                }
            }
        }
    }

    static int[] strikeNum(ArrayList<Integer> randomNumber, ArrayList<Integer> inputList) {
        int[] result;
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomNumber.size(); i++) {
            for (int j = 0; j < inputList.size(); j++) {
                if (i == j && randomNumber.get(i) == inputList.get(j)) strike++;
                if (i != j && randomNumber.get(i) == inputList.get(j)) ball++;
            }
        }

        result = new int[] {strike, ball};

        return result;
    }

    static boolean printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike > 0 && strike < 3 && ball == 0) System.out.println(strike + "스트라이크");
        else if (strike == 0 && ball > 0) System.out.println(ball + "볼");
        else if (strike > 0 && strike < 3 && ball > 0) System.out.println(ball + "볼" + " " + strike + "스트라이크");
        else if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
}