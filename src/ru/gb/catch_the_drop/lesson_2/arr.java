package ru.gb.catch_the_drop.lesson_2;

import java.util.Arrays;

public class arr {
    public static void replacement (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) {
                arr[i]=1;
            }
            else if (arr[i]==1){
                arr[i]=0;
            }
        }
    }


    public static void Numbers3 (int arr []) {
        for (int i = 0, j = 1; i < arr.length; i++, j+=3){
            arr [i] = j;
        }
    }

    public static void multiplication (int arr []) {
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < 6)
                arr [i] *= 2;
        }
    }
// Не правильно прочитал задание, только потом понял что надо создать методЫ
// (остаалю так, т.к. думаю понятно, что я смогу по этому примеру написать по отдельному методу =) )
    public static void MinMax (int arr []) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            else if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }

    public static void diagonal (int arr [][]){
        int s = 1;
        for (int i = 0, e=arr.length-1; i < arr.length; i++, e--){
            arr[i][e] = s;
        }
        for (int i=0,j=0; i < arr.length; i++,j++){
            arr[i][j] = s;
        }
    }





    public static boolean checkBalance(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftSum = arr[left];
        int rightSum = arr[right];

        while (true) {
            if (leftSum < rightSum) {
                left++;
                if (left == right) {
                    break;
                }
                leftSum += arr[left];
            } else {
                right--;
                if (left == right) {
                    break;
                }
                rightSum += arr[right];
            }
        }
        return leftSum == rightSum;
    }


    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replacement(arr);

        int[] arr2 = new int[8];
        Numbers3(arr2);

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplication(arr3);

        int[] arr4 = {2, 10, 6, 4, 151, 8, 10, 4, 8, 2, 9, 3};
        MinMax(arr4);

        int[][] arr55  = new int [5][5];
        diagonal(arr55);

        int[]arr66 = {2,4,5,3,6,4};
        checkBalance(arr66);


            }
        }
