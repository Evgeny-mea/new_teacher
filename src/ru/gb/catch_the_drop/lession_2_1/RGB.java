package ru.gb.catch_the_drop.lession_2_1;

import java.awt.*;

public class RGB extends Sprite {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int r = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        int g = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time /2));
        int b = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2));

        color = new Color(r, g, b);
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }

}
