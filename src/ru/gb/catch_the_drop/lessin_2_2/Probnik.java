package ru.gb.catch_the_drop.lessin_2_2;

import java.util.Arrays;

public class Probnik {
    //Матрицы
    private static final String Matrix_1 = "10 3 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String Matrix_2 = "10 3 3 m\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String Matrix_3 = "10 3 3 1\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    //Максимальное кол-во сторон
    private static int MaxStrings = 4;

    private static String[][] StringInMatrix(String str) throws RuntimeException {
        //Добовляем матрицу в массив
        String[] arrLine = str.split("\n");
        if (arrLine.length != MaxStrings)
            throw new RuntimeException("Размер матрицы " + arrLine.length + ":\n" + str);
        //Создание и заполнение массива
        String arrNum[][] = new String[MaxStrings][];
        for (int i = 0; i < MaxStrings; i++) {
            arrNum[i] = arrLine[i].split(" ");
            if (arrNum[i].length != MaxStrings)
        //Исключение
                throw new RuntimeException("Размер матрицы " + arrNum[i].length + "\n" + str);
        }
        return arrNum;
    }

    private static float Summa(String[][] arr_mx) {
        //Сммируем и делим на 2
        int sum = 0;
        for (int i = 0; i < arr_mx.length; i++) {
            for (int j = 0; j < arr_mx[i].length; j++)
                try {
                    sum += Integer.parseInt(arr_mx[i][j]);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Необходимо убрать символ: " + arr_mx[i][j]);
                }
        }
        return sum / 2;
    }


    public static void main(String[] args) {
         try {
            final String[][] matrix = StringInMatrix(Matrix_2);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("Сумма " + Summa(matrix));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
