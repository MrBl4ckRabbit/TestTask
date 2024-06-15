package simple_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        try {
            String[] parts = input.split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат");
            }

            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            char operation = parts[1].charAt(0);

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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа", e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка ввода: " + e.getMessage(), e);
        }
    }
}
