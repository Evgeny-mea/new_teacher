package ru.gb.catch_the_drop.lesson_44;

public class Employees {
    private String name;        // ФИО
    private String position ;   // Должность
    private int tel;            // Телефон
    private int income;         // Зарплата
    private int age;            // Возраст

    Employees(String name, String zp, int tel, int income, int age) {
        this.name = name;
        this.position = zp;
        this.tel = tel;
        this.income = income;
        this.age = age;

    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getPhone(){
        return tel;
    }
    public int getIncome(){
        return income;
    }
    public int getAge() {
        return age;
    }
}