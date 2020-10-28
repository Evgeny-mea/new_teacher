package ru.gb.catch_the_drop.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class x0 {
    public static int mapSize = 3;
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();


    public static char MAN_X = 'x';
    public static char PC_0 = '0';
    public static char init = '_';

    public static char[][] map;

    public static void incMap() { //Инициализация пустого поля
        map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++)
            for (int y = 0; y < mapSize; y++) {
                map[i][y] = init;
            }
    }


    public static void printMap() { //Печатаем поле
        for (int i = 0; i < mapSize; i++) {
            for (int y = 0; y < mapSize; y++) {
                System.out.print(map[i][y] + "|");
            }
            System.out.println();
        }
    }

    public static boolean Win(char c){ // Проверка на победу
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) return true;
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) return true;
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) return true;

        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) return true;
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) return true;
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) return true;

        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        return false;
    }

    public static boolean noWin(){ // Проверка на ничью
        for (int i = 0; i < mapSize; i++){
            for (int y = 0; y < mapSize; y++){
                if (map[i][y] == init) return false;
            }
    }
    return true;
}

    public static boolean enterUser (int x, int y) { //Проверка ввод чисел в придел массива
            return y >= 0 && y < mapSize && x >= 0 && x < mapSize;
    }

    public static boolean clearSector (int x, int y) { //Проверка на пустую секцию
        return map[x][y] == init;
    }

    public static void goMan(){ // Ход игрока
        int x;
        int y;
        do{
            System.out.println("Введите вертикальные координаты: ");
            x = SCANNER.nextInt() -1;
            System.out.println("Введите горизонтальные координаты: ");
            y = SCANNER.nextInt() -1;
        } while (!clearSector(x,y)||!enterUser(x,y));{
            map[x][y] = MAN_X;
        };
    }
    public static void goPC(){ // Ход ПК
        int x;
        int y;
        do{
            x=RANDOM.nextInt(mapSize);
            y=RANDOM.nextInt(mapSize);
        } while (!clearSector(x,y));
        map[x][y] = PC_0;
    }





        public static void main (String[]args){
            incMap();
            printMap();
            while (true){
                goMan();
                printMap();
                if (Win(MAN_X)){
                    System.out.println("Человек WIN!");
                    break;
                }
                if (noWin()){
                    System.out.println("Ничья");
                    break;
                }
                goPC();
                printMap();
                if (Win(PC_0)){
                    System.out.println("ПК WIN!");
                    break;
                }
                if (noWin()){
                    System.out.println("Ничья");
                    break;
                }
            }
        }
    }

