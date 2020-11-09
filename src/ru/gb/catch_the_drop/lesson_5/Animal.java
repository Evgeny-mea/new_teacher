package ru.gb.catch_the_drop.lesson_5;

public class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    protected float maxJump ;

    public Animal(String name, int maxRun, int maxSwim, float maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    void move(int dist) {
        if (maxRun > dist) System.out.println(name + " пробежал " + dist + " метра");
        else System.out.println(name +  " не смог пробежать " + dist + " метра" );
    }
    String swim(int dist) {
        if (maxSwim > dist) return name + "Проплыл";
        else return name + " не смог проплыть" + dist + " метра";
//            System.out.println(name + " не смог проплыть " + dist + " метра");
    }
    void jump(float dist) {
        if (maxJump > dist) System.out.println(name + " прыгнул " + dist + " метра");
        else System.out.println(name + " не смог прыгнуть " + dist + " метра");
    }
}
    // бежать, плыть, перепрыгивать препятствие

