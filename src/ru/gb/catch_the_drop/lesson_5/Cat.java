package ru.gb.catch_the_drop.lesson_5;

public class Cat extends Animal{

    Cat (String name, int maxRun, int maxSwim, float maxjump) {
        super(name, maxRun, maxSwim, maxjump);
     }

    @Override
        String swim (int dist) {
        return name + " отказался плавать";
     }
    }


