package ru.gb.catch_the_drop.lesson_1;

public class Main {



    public static int summ(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean summw(int a, int b) {
        int s = a + b;
        if (s >= 10 && s <= 20) {
            return true;
        } else
            return false;
    }


    public static void revers(int a) {
        if (a >= 100 && a <= 999) {
            String str = Integer.toString(a);
            String reverse = new StringBuffer(str).reverse().toString();
            System.out.println(reverse);
        } else {
            System.out.println(a);
        }
    }

    public static void LeapYear (int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println("Високосный год");
        } else {
            System.out.println("Не високосный год");
        }
    }

    public static void main(String[] args) {
        byte Byte = 127;
        short Short = 32767;
        long Long = 9223372036854775807L;
        float Float = 11.23f;
        double Double = 111.222;
        char Char = 'c';
        boolean FalseTrue = true;

        System.out.println(Byte);
        System.out.println(Short);
        System.out.println(Long);

        System.out.println();

        System.out.println(summ(12, 343, 43, 2));
        System.out.println(summw(3, 3));
        revers(118);
        LeapYear(2020);


    }
}
