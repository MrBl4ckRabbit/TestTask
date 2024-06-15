package advanced_calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        input = input.replaceAll("\\s+", "");
        String regex = "(\\d+)([-+*/])(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(3));
            char operation = matcher.group(2).charAt(0);

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }

            int result = switch (operation) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> throw new IllegalArgumentException("Неверная операция");
            };
            return String.valueOf(result);
        } else {
            throw new IllegalArgumentException("Неверный формат");
        }
    }
}
