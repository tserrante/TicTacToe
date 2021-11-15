package com.mygdx.game.tictactoe;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Piece extends Board
{

    Sprite sprite;
    Boolean occupied;
    int value;

    Piece(Sprite sprite, Boolean occupied, int value)
    {
        this.sprite = sprite;
        this.occupied = occupied;
        this.value = value;
    }
}
