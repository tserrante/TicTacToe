package com.mygdx.game.tictactoe;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class BoardPiece
{
    private Sprite boardSprite;
    private String boardPieceName;
    private int state; // 0 = no x or o, 1 = player one, 2 = player two

    BoardPiece(Sprite boardSprite, String boardPieceName )
    {
        this.boardSprite = boardSprite;
        this.boardPieceName = boardPieceName;
        state = 0;
    }

    public Sprite getBoardSprite()
    {
        return boardSprite;
    }

    public int getState()
    {
        return state;
    }

    public String getBoardPieceName()
    {
        return boardPieceName;
    }

    public void setState(int state)
    {
        if(state == 0 || state == 1 || state == 2)
            this.state = state;
        else
            System.out.println("Incorrect BoardPiece state");
    }


}
