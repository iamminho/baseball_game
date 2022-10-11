import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
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


    static boolean inputCheck (String input) {
        String pattern = "^[1-9]*$";
        HashSet<Character> set = new HashSet<>();

        //false 조건들

        // 글자 수가 3개가 아닐때
        if (input.length() != 3) return false;

        // 글자안에 특수문자, 공백, 0등 1~9의 숫자가 아닐때
        if (!Pattern.matches(pattern, input)) return false;

        // 겹치는 숫자가 있을때
        for (int i = 0; i < input.length(); i++) set.add(input.charAt(i));
        if (set.size() != input.length()) return false;

        return true;
    }

    static ArrayList<Integer> inputNum() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            int tmp = input.charAt(i) - '0';
            numbers.add(tmp);
        }

        return numbers;
    }


    //    static void baseballGame (ArrayList<Integer> randomNumber) {
    //        boolean stopOrGo = false;
    //
    //        while (!stopOrGo) {
    //
    //        }
    //    }
}