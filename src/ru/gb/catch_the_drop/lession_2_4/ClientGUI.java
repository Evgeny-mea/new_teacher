package ru.gb.catch_the_drop.lession_2_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400; // Ширина
    private static final int HEIGHT = 300; // Высота

    private final JTextArea log = new JTextArea(); // Поле сообщений
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3)); //Панель 2 стр. х 3столб.
    private final JTextField tfIPAddress = new JTextField("127.0.0.1"); // Поле АйПи Адреса
    private final JTextField tfPort = new JTextField("8189"); //Поле Порта
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");  // Галочка поверх окон
    private final JTextField tfLogin = new JTextField("ivan");  // Логин
    private final JPasswordField tfPassword = new JPasswordField("123"); // Пароль
    private final JButton btnLogin = new JButton("Login");  // Кнопка залогиниться

    private final JPanel panelBottom = new JPanel(new BorderLayout()); //Создаем панель с кнопками и вводом текста
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>"); // Дисконект
    private final JTextField tfMessage = new JTextField(); //Текст внизу
    private final JButton btnSend = new JButton("Send"); //Отправить

    private final JList<String> userList = new JList<>(); //Массив с пользователями
    private boolean shownIoErrors = false;

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this); //Установка непойманых исключений по умолчанию
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Останавливаем приложение при закрытие
        setLocationRelativeTo(null); //Размещение рабочего окна
        setSize(WIDTH, HEIGHT); // Размеры окна
        log.setEditable(false); // Запрет на ввод в окно чата
        log.setLineWrap(true);  // Перенос строк
        JScrollPane scrollLog = new JScrollPane(log); //Скролинг окна с чатом
        JScrollPane scrollUser = new JScrollPane(userList); //Скролинг окна с пользователями
        String[] users = {"user1", "user2", "user3", "user4", "user5", // Массив с пользователями
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users); // Добовляем users в userList списком
        scrollUser.setPreferredSize(new Dimension(100, 0)); //Устанавливаем для размеры для окна юзеров(ширину)
        cbAlwaysOnTop.addActionListener(this); //Передаем параметры в ActionListener (Галочка)
        btnSend.addActionListener(this); //Передаем параметры в ActionListener (Отправить)
        tfMessage.addActionListener(this); //Передаем параметры в ActionListener (Поле вводимого сообщения)

        // Размешаем все объекты на окне
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Как работает actionPerformed - почитать
        Object src = e.getSource(); // Слушатель события
        if (src == cbAlwaysOnTop) { // Если слушатель совпал с действием нажатия на галочку то ->
            setAlwaysOnTop(cbAlwaysOnTop.isSelected()); // setAlwaysOnTop - устанавливает положение поверх окон. isSelected - переключает между true false
        } else if (src == btnSend || src == tfMessage) {  // Если первое не сработало, то проверяем нажатие кнопки или событие в поле ввода
            sendMessage();  //Отправка сообщения
        } else {   //Ловим ошибку
            showException(Thread.currentThread(), new RuntimeException("Unknown action source: " + src));
        }
    }

    private void sendMessage() {
        String msg = tfMessage.getText();    // Помещаем весь текст из окна ввода сообщения в msg
        String username = tfLogin.getText(); // Берем логин пользователя, помещаем в username
        msg = msg.trim(); // Не отправляем пробелы в чат
        if ("".equals(msg)) return; // Сравниваем пустой текст с msg возращаем тру \ фолс
        tfMessage.setText(null); // Убирает текст после отправки сообщения
        putLog(String.format("%s: %s", username, msg)); // "Собираем" сообщение  Пользователь + Сообщение
        wrtMsgToLogFile(msg, username); // Передаем Текст + Логин в метод для записи  в текстовый документ
    }

    private void wrtMsgToLogFile(String msg, String username) {
        try (FileWriter out = new FileWriter("log.txt", true)) { //Создаем текстовый док. для записи
            out.write(username + ": " + msg + "\n"); // Записываем Логин и Сообщение
            out.flush(); // Очищаем поток
        } catch (IOException e) {  //Ловим и обрабатываем ошибки
            if (!shownIoErrors) {
                shownIoErrors = true;
                showException(Thread.currentThread(), e);
            }
        }
    }

    private void putLog(String msg) {
        if ("".equals(msg)) return;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n"); //добовляем текст сообщения в конец
                log.setCaretPosition(log.getDocument().getLength());//НЕПОНЯТНОООО
            }
        });
    }

    private void showException(Thread t, Throwable e) {
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        if (ste.length == 0)
            msg = "Empty Stacktrace";
        else {
            msg = String.format("Exception in \"%s\" %s: %s\n\tat %s",
                    t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
            JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, msg, "Exception", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        showException(t, e);
        System.exit(1);
    }
}
