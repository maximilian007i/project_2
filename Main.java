import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Воодить Через пробел 1_+_1
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("throws Exception");
        }

        String strNumber1 = parts[0];
        String strNumber2 = parts[2];

        boolean isRoman = isRomanNumerals(strNumber1) && isRomanNumerals(strNumber2);
        boolean isArabic = isArabicNumerals(strNumber1) && isArabicNumerals(strNumber2);
        if (!isRoman && !isArabic) {
            throw new IllegalArgumentException("throws Exception");
        }

        int number1, number2, result;
        char operator = parts[1].charAt(0);

        if (isRoman){
            number1 = romanToArabic(strNumber1);
            number2 = romanToArabic(strNumber2);
        } else {
            // Integer.parseInt позволяет преобразовать символ в целое число.
            number1 = Integer.parseInt(strNumber1);
            number2 = Integer.parseInt(strNumber2);
        }

        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
            throw new IllegalArgumentException("throws Exception");
        }


        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number1 == 0 || number2 == 0) {
                    throw new ArithmeticException("throws Exception");
                }
                result = number1 / number2;
                break;
            default:
                throw new UnsupportedOperationException("throws Exception");
        }

        if (isArabic){
            return String.valueOf(result);
        }
        else return arabicToRoman(result);
    }

    private static boolean isRomanNumerals(String str) {
        return str.matches("[IVXLC]+");
    }

    private static boolean isArabicNumerals(String str) {
        return str.matches("-?\\d+");
    }

    public static String[] romanNumerals = {
            "Z", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"
    };

    public static int romanToArabic(String romanNumeral){
        for (int i = 0; i < romanNumerals.length; i++){
            if (romanNumerals[i].equals(romanNumeral)) {
                return i;
            }
        }
        return 0;
    }

    public static String arabicToRoman(int arabicNumeral){
        if (arabicNumeral <= 0){
            throw new IllegalArgumentException("throws Exception");
        }
        return romanNumerals[arabicNumeral];
    }
}