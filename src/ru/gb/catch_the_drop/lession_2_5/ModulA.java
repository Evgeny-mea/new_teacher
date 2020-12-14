package ru.gb.catch_the_drop.lession_2_5;

public class ModulA extends Thread {

    private final float[] arr;
    private int offset;

    ModulA(float[] arr, int offset) {
        this.arr = arr;
        this.offset = offset;
        start();
    }


    @Override
    public void run() {
        System.out.println("Старт потока " + getName());
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + (i + offset) / 5) *
                    Math.cos(0.2f + (i + offset) / 5) *
                    Math.cos(0.4f + (i + offset) / 2));
        System.out.println("Конец потока " + getName());
    }
}
