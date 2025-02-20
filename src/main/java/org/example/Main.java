package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        System.out.println(isPerfectNumber(6));  // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5));  // false
        System.out.println(isPerfectNumber(-1)); // false

        System.out.println(numberToWords(123));  // "One Two Three"
        System.out.println(numberToWords(1010)); // "One Zero One Zero"
        System.out.println(numberToWords(-12));  // "Invalid Value"
    }
    public static boolean isPalindrome(int number) {

        int original = number;
        int reversed = 0;

        // Sayıyı tersine çevirme
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        // Orijinal sayı ile ters çevrilmiş sayıyı karşılaştır
        return original == reversed;
    }
    // Mükemmel sayıyı kontrol eden metod
    public static boolean isPerfectNumber(int number) {
        // Negatif sayılar mükemmel sayı olamaz
        if (number < 1) {
            return false;
        }
        int sum = 0;
        // Kendisi hariç bölenleri toplama
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        // Toplamın kendisine eşit olup olmadığını kontrol et
        return sum == number;
    }
    // Sayıyı kelimelere döken metod
    public static String numberToWords(int number) {
        // Negatif sayılar için geçersiz değer
        if (number < 0) {
            return "Invalid Value";
        }

        // Sayının sıfır olup olmadığını kontrol et
        if (number == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        String[] numberWords = {
                "Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"
        };

        // Sayıyı kelimelere dökme
        while (number > 0) {
            int digit = number % 10;
            words.insert(0, numberWords[digit] + " ");
            number /= 10;
        }

        return words.toString().trim(); // Sonuçta boşlukları temizle
    }

}



