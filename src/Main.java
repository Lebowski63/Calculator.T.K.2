import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String vvod = s.nextLine();
        calc(vvod);
    }
        public static String calc (String input){
            String operStr = " ";
            char oper = ' ';
            char[] symbol = new char[10];
            for (int i = 1; i < input.length(); i++) {
                symbol[i] = input.charAt(i);
                if (symbol[i] == '+') {
                    oper = '+';
                    operStr = "\\+";
                }
                if (symbol[i] == '-') {
                    oper = '-';
                    operStr = "-";
                }
                if (symbol[i] == '*') {
                    oper = '*';
                    operStr = "\\*";
                }
                if (symbol[i] == '/') {
                    oper = '/';
                    operStr = "/";
                }
            }
            int num1 = 0;
            int num2 = 0;
            int result = 0;
            int arabresult = 0;
            String[] numbers = input.split(operStr);
            if (numbers.length > 2) {
                System.out.println("Калькулятор считает только две переменные! Попробуйте снова.");
                System.exit(0);
            }
            try {
                num1 = Roman.roman(numbers[0]);
                num2 = Roman.roman(numbers[1]);
            } catch (ArithmeticException e) {
                System.out.println("Нет символа для выполнения операции или отсутствует вторая переменная! Попробуйте снова.");
                System.exit(0);
            }
            if (num1 == 0 | num2 == 0) {
                result = 0;
                try {
                    num1 = Integer.parseInt(numbers[0]);
                    num2 = Integer.parseInt(numbers[1]);
                    if (num1 > 10 | num2 > 10 | num2 < 0 | num1 < 0) {
                        System.out.println("Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! Попробуйте снова.");
                        System.exit(0);
                    }
                    arabresult = Calculate.calc(num1, num2, oper);
                    System.out.println(arabresult);
                } catch (NumberFormatException e) {
                    System.out.println("Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! ");
                } catch (ArithmeticException e) {
                    System.out.println("На ноль делить нельзя! Попробуйте снова.");
                }
            } else {
                try {
                    result = Calculate.calc(num1, num2, oper);
                    if (result == 0) {
                        System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа! Попробуйте снова.");
                        System.exit(0);
                    }
                    String romresult = RomanT.romanT(result);
                    System.out.println(romresult);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Результат не может быть отрицательным или нулем.");
                }
            }
            return input;
        }
    }

