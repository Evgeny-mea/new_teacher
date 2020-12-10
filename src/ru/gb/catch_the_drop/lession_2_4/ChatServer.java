package ru.gb.catch_the_drop.lession_2_4;

public class ChatServer {
    private int port;
    public void start (int port){
        System.out.println("Server start " + port);
    }
    public void stop (){
        System.out.println("Server stopped");
    }
}
