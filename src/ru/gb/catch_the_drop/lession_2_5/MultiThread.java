package ru.gb.catch_the_drop.lession_2_5;

import java.util.Arrays;

public class MultiThread {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final float[] arrOne = new float[SIZE];
    private static final float[] arrTwo = new float[SIZE];

    public static void main(String[] args) {
        // Прогоняем через цикл и заполняем 1
        Arrays.fill(arrOne, 1f);
        Arrays.fill(arrTwo, 1f);


        //Засикаем время, вызываем метод, узнаем дельту
        long startTime = System.nanoTime();
        methodOne(arrOne);
        long deltaTime = System.nanoTime() - startTime;
        System.out.println("Время работы первого метода: " + deltaTime * 1e-9f);

        //Запускаем второй метод
        startTime = System.nanoTime();
        calculateArrayTwoThreads(arrTwo);
        deltaTime = System.nanoTime() - startTime;
        System.out.println("Время работы второго метода " + deltaTime * 1e-9f);

        //Сравниваем массивы
        if (Arrays.equals(arrOne, arrTwo)) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы не равны");
        }
    }

    //Метод для вычесления значений
    private static void methodOne (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }


    //Метод для разделение массива
    private static void calculateArrayTwoThreads(float[] arr) {
        //Создаем массивы
        final float[] a1 = new float[HALF];
        final float[] a2 = new float[HALF];
        //Копируем массивы
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        //Отправляем на второй поток
        ModulA threadOne = new ModulA(a1, 0);
        ModulA threadTwo = new ModulA(a2, HALF);

        try {
            threadOne.join(); // join выполняет поток и отдает его дальше, после того как завершит работу
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Склеиваем
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
    }

}


