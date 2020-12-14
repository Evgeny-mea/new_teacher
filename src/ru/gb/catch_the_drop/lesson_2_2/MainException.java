package ru.gb.catch_the_drop.lesson_2_2;

import java.util.Arrays;

public class MainException {
    public static void main(String[] args) {
        String str = "1233\n2345\n3467\n5677";
        String[] arr= str.split("\n");
        System.out.println(Arrays.toString(arr));
    }
}
