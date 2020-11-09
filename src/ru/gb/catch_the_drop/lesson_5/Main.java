package ru.gb.catch_the_drop.lesson_5;

public class Main {
    public static void main (String[]args){


        Cat Barsik = new Cat("Барсик",12,12,150f);
        Dog Tuzik = new Dog("Тузик", 13,12,4.f);
        Bird Blue = new Bird("Синий", 12,31, 1.0f);
        Horse White = new Horse("Белый", 76,12,1.0f);

        Animal[] animals = new Animal[]{Barsik, Tuzik, Blue, White};
        for (Animal a : animals) {
            a.jump(0.3f);
            a.move(655);
            System.out.println(a.swim(1111));
        }

        for (int i = 0; i < animals.length; i ++) {
            Animal a = animals[i];
        }


/*        System.out.println(Tuzik.name);
        Tuzik.jump(0.3f);
        Tuzik.swim(1111);
        Tuzik.move(655);

        System.out.println();

        System.out.println(Barsik.name);
        Barsik.jump(0.3f);
        Barsik.swim(122);
        System.out.println(Barsik.swim(122));
        Barsik.move(2000);*/
    }
}
