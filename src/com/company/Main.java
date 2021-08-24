package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int SIZE = 10;
        int warField[][] = new int[SIZE][SIZE];
        int EMPTY = 0;
        int SHIP = 1;
        int DEAD = 2;
        int MISS = 3;
        int counter = 0;
        int deadShips = 0;

        int MAX_COUNT = 10;

        for (int i = 0; i < MAX_COUNT; i++) {
            int shipPlace1 = random.nextInt(SIZE);
            int shipPlace2 = random.nextInt(SIZE);

            if (warField[shipPlace1][shipPlace2] == SHIP) {
                i--;
            }
            warField[shipPlace1][shipPlace2] = SHIP;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%2d", warField[i][j]);
            }
            System.out.println();
        }

        while (counter < 30) {
            System.out.println("Введите координаты для атаки (осталось " + String.valueOf(30 - counter) + "):");
            String input = scanner.nextLine();
            int separatorPos = input.indexOf(":");
            int x = Integer.parseInt(input.substring(0, separatorPos));
            int y = Integer.parseInt(input.substring(separatorPos + 1, input.length()));

            if (warField[x - 1][y - 1] == EMPTY) {
                System.out.println("МИМО");
                warField[x - 1][y - 1] = MISS;
            }
            else if (warField[x - 1][y - 1] == SHIP) {
                System.out.println("КОРАБЛЬ ЗАСТРЕЛЕН");
                warField[x - 1][y - 1] = DEAD;
                deadShips++;
            }
            else {
                System.out.println("Хорошая попытка, но вы сюда уже стреляли");
            }

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.format("%2d", warField[i][j]);
                }
                System.out.println();
            }

            if (deadShips > 9) {
                System.out.println("ПОБЕДА! Поздравляем, вы уничтожили все корабли");
                break;
            }
            counter++;
        }
    }
}
