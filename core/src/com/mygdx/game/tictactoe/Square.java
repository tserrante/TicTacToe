package com.mygdx.game.tictactoe;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Square extends GameBoard
{
    private int x; // x anchor of a square object
    private int y; // y anchor of a square object


    // for the origin square
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getCoordinateX()
    { return x; }

    public int getCoordinateY()
    { return y; }

    public void draw(ShapeRenderer square)
    {
        square.rect(x, y, squareWidth, squareHeight );
    }



}
