package ru.gb.catch_the_drop.lession_7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    public GameMap(){
        setBackground(Color.cyan);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode:%d, size:%d, win:%d\n", gameMode, fieldSizeX, winLength);
    }
}
