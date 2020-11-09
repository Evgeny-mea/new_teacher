package ru.gb.catch_the_drop.lesson_6;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream textFileOne = new FileInputStream("textOne.txt");
            FileOutputStream textFileTwo = new FileOutputStream("textTwo.txt", true);

            int b;
            while ((b = textFileOne.read()) != -1) {
                textFileTwo.write((char) b);
            }
            
        }catch (Exception e) {
            System.out.println("Упс, что-то пошло не так!");
        }
    }
}
