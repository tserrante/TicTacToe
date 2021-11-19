package com.mygdx.game.tictactoe;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class BoardPiece implements Comparable<BoardPiece>
{
    private final Sprite boardSprite;
    private final String boardPieceName;
    private PLAYER_ID pieceState; // tracks who is on the piece

    BoardPiece(Sprite boardSprite, String boardPieceName )
    {
        this.boardSprite = boardSprite;
        this.boardPieceName = boardPieceName;
        pieceState = PLAYER_ID.NO_PLAYER;
    }

    public Sprite getBoardSprite()
    {
        return boardSprite;
    }

    public PLAYER_ID getState()
    {
        return pieceState;
    }

    public String getBoardPieceName()
    {
        return boardPieceName;
    }

    public void setBoardPieceState(PLAYER_ID pieceState)
    {
        if(this.pieceState == PLAYER_ID.NO_PLAYER &&( pieceState == PLAYER_ID.PLAYER_ONE || pieceState == PLAYER_ID.PLAYER_TWO))
            this.pieceState =  pieceState;
        else
            System.out.println("Incorrect BoardPiece state");
    }

    public PLAYER_ID getPieceState()
    {
        return pieceState;
    }


    public BoardPiece getPieceObj()
    {
        return this;
    }

    @Override
    public int compareTo(BoardPiece o)
    {
        return 1;
    }
}
