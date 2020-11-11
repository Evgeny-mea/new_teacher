package ru.gb.catch_the_drop.lession_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private MainWin mainWin;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    Settings(MainWin mainWin){
        this.mainWin = mainWin; //Получаем параметры главного окна
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //Указываем размер окна
        Rectangle gameWindowBounds = mainWin.getBounds(); //Передаем и центруем показ окна в окне MainWin
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setLayout(new GridLayout(10, 1)); // Задаем 10 строчек. 1 столбец
        addGameModeControls();  // Добовляем выбор режима игры
        addFieldControls();    //  Добовление слайеров
        JButton btnStartGame = new JButton("Start");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 collectDataFromControlsAndStartGame();
            }
        });
        add(btnStartGame);
        setVisible(false);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode:"));
        humVSAI = new JRadioButton("Human vs. AI", true); //Устанавливаем радиокнопку по умолчанию
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup(); // Обединяем радиокнопки
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls () {
        JLabel lbFildSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);  //Текст с размером поля
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH); //Текст с размером победного выигрыша
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE); //Слайдер с размером поля
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE); //Слайдер с размером выигрыша
        slideFieldSize.addChangeListener(new ChangeListener() { //Слушатель слайдера поля
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFildSize.setText(FIELD_SIZE_PREFIX+currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });
        slideWinLen.addChangeListener(new ChangeListener() { //Слушатель слайдера выигрыша
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX+slideWinLen.getValue());
            }
        });   //Размешаем все это на окне
        add(new JLabel("Fild Size"));
        add(lbFildSize);
        add(slideFieldSize);
        add(new JLabel("Win Length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void collectDataFromControlsAndStartGame(){
        int gameMode; //Режим игры
        if (humVSAI.isSelected()){
            gameMode = GameMap.MODE_HVA;
        }else if (humVShum.isSelected()){
            gameMode = GameMap.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }
        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();
        mainWin.acceptSettings(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }

}
