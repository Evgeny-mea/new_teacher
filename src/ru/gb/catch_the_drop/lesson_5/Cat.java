package ru.gb.catch_the_drop.lesson_5;

public class Cat extends Animal{
    Cat (String name, int maxRun, int maxSwim, float maxjump) {
        super(name, maxRun = 200,0,2.0f);
    }


    @Override
    void swim (int dist) {
        System.out.println(name + " отказался плавать");
    }
    }


