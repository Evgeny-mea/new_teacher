package ru.gb.catch_the_drop.lesson_5;

public class Main {
    public static void main (String[]args){
        Cat Barsik = new Cat("Барсик",12,12,1.2f);
        Dog Tuzik = new Dog("Тузик", 13,12,4.f);
        Bird Blue = new Bird("Синий", 12,31, 1.0f);
        Horse White = new Horse("Белый", 76,12,1.0f);

        System.out.println(Tuzik.name);
        Tuzik.jump(0.3f);
        Tuzik.swim(1111);
        Tuzik.move(655);

        System.out.println(Barsik.name);
        Barsik.jump(0.3f);
        Barsik.swim(122);
        Barsik.move(111);
    }
}
