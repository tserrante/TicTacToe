package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;

public class GameBoard
{
    // store the dimensions of the current screen
    protected final static int screenWidth = Gdx.graphics.getWidth();
    protected final static int screenHeight = Gdx.graphics.getHeight();

    // store the dimensions of a square
    protected final static int squareWidth = 75;
    protected final static int squareHeight = 75;
    // variables for the bottom left square on the window
    // all other
    protected final static int x_SeedOffset = (screenWidth / 2) - (int)(0.5 * squareWidth) - squareWidth;
    protected final static int y_SeedOffset = (screenHeight / 2) - (int)(0.5 * squareHeight) - squareHeight;

    public static int getSquareWidth()
    { return squareWidth; }

    public static int getSquareHeight()
    { return squareHeight; }

    public static int getXoffset()
    { return x_SeedOffset; }

    public static int getYoffset()
    { return y_SeedOffset; }

    public static int getScreenWidth()
    { return screenWidth; }

    public static int getScreenHeight()
    { return screenHeight; }
}
