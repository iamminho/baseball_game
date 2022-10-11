import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    public static ArrayList<Integer> randomNum() {
        Random rd = new Random();
        ArrayList<Integer> numberList =  new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberList.add(rd.nextInt(9) + 1);
        }

        return numberList;
    }
    public static boolean inputCheck (String input) {
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
    public static ArrayList<Integer> inputNum(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int tmp = input.charAt(i) - '0';
            numbers.add(tmp);
        }

        return numbers;
    }
    public static boolean printResult(int[] result) {
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

    public static int inputNumber () {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String number = sc.nextLine();
            if (number.equals("1") || number.equals("2")) return Integer.parseInt(number);
            System.out.println("형식에 맞지 않는 입력입니다. 다시입력해 주시기 바랍니다.");
        }
    }
}
