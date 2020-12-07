package ru.gb.catch_the_drop.lesson_2_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Main_2_4 {
    private static final String words =
                            "Создать массив с набором слов 20-30 слов должны встречаться повторяющиеся " +
                            "Создать массив с набором слов 20-30 слов должны встречаться повторяющиеся " +
                            "Создать набором должны встречаться повторяющиеся ";

    private static TreeSet<String> words(String[] arr) {
        return new TreeSet<>(Arrays.asList(arr));
    }

    private static HashMap<String, Integer> re_word(String[] arr) {
        HashMap<String, Integer> hash_map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (hash_map.containsKey(word)) {
                hash_map.put(word, hash_map.get(word) + 1);
            } else {
                hash_map.put(word, 1);
            }
        }
        return hash_map;
    }

    public static void main(String[] args) {
        System.out.println(words(words.split(" ")));
        System.out.println(re_word(words.split(" ")));
    }
}