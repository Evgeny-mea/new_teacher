package ru.gb.catch_the_drop.lesson_5;

public class Bird extends Animal{
    Bird(String name, int maxRun, int maxSwim, float maxjump){
        super(name,5, 0,0.2f);
    }
    @Override
    void swim (int dist) {
        System.out.println(name + " отказался плавать");
    }

}

