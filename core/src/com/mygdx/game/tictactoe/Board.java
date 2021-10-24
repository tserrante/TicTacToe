package com.mygdx.game.tictactoe;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Board
{
    private int x; // x anchor of board
    private int y; // y anchor of board
    private int size; // ????
    private ShapeRenderer shape;

    public Board(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
    }



}
