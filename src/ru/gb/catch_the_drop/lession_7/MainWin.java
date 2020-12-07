package ru.gb.catch_the_drop.lession_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWin extends JFrame {
    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 150;
    private GameMap map;
    MainWin(){
        setSize(WIN_WIDTH, WIN_HEIGHT); //Устанавливаем размер поля
        setLocation(WIN_POSX, WIN_POSY); //Устанавливаем позицию поля на рабочем столе
        setTitle("X0 - Game"); //Название приложения
        setResizable(false); //Запрет на изменения размера окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Указываем что при закрытии окна, программа останавливается
        JButton btnStart = new JButton("Start"); //Создаем кнопку
        JButton btnStop = new JButton("Stop");
        JPanel panelBottom = new JPanel(); //Создаем оболочку для кнопок
        panelBottom.setLayout(new GridLayout(1,2));  // 1 строка, 2 столбца
        panelBottom.add(btnStart); // Помещаем кнопки в panelBottom
        panelBottom.add(btnStop);
        map = new GameMap(); // Делаем "доступ" класса GameMap
        Settings setWin = new Settings(this); // Передаем mainWin в Setting

        btnStart.addActionListener(new ActionListener() { // Делаем переопределение кнопки - старт.
            @Override
            public void actionPerformed(ActionEvent e) {
                setWin.setVisible(true); // Переаем в Settings, setVisible - true (делаем окно видимым)
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Делаем при нажатии кнопки СТОП - Остановку программы(выход)
            }
        });
        add(map); // Размещаем игровое поле
        add(panelBottom, BorderLayout.SOUTH); // Размещаем кнопки внизу окна
        setVisible(true); // Делаем окно видимым


    } // Передаем параметры в GameMap
    public void acceptSettings(int gameMode, int fildSizeX, int fildSizeY, int winLength) {
        map.startNewGame(gameMode, fildSizeX, fildSizeY, winLength);
    }
}
