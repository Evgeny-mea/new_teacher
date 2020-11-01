package ru.gb.catch_the_drop.lesson_44;

public class Conclusion {

    public static void main (String[]args) {
        Employees a = new Employees("Иван", "Программист", 231 - 98, 30000, 32);
        Employees b = new Employees("Коля", "Менеджер", 231 - 98, 30000, 39);
        Employees c = new Employees("Ольга", "Зам.Директора", 231 - 98, 30000, 42);
        Employees d = new Employees("Мария", "Директор", 231 - 98, 30000, 34);
        Employees f = new Employees("Александра", "Бухгалтер", 231 - 98, 30000, 54);

        Employees[] nums = new Employees[5];
        nums[0] = a;

        nums[1] = b;
        nums[2] = c;
        nums[3] = d;
        nums[4] = f;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i].getAge() >= 40)
                System.out.printf("    ФИО: %s,             Должность: %s,      Зарплата: %d,       Телефон: %d,        Возраст: %d \n",
                        nums[i].getName(), nums[i].getPosition(), nums[i].getIncome(), nums[i].getPhone(), nums[i].getAge());
        }
    }
}