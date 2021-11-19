package com.mygdx.game.tictactoe;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class BoardPiece extends Sprite implements Comparable<BoardPiece>
{

    private final String boardPieceName;
    private PLAYER_ID pieceState; // tracks who is on the piece

    BoardPiece(TextureAtlas.AtlasRegion region, String boardPieceName )
    {
        super(region);
        this.boardPieceName = boardPieceName;
        pieceState = PLAYER_ID.NO_PLAYER;
    }


    public String getBoardPieceName()
    {
        return boardPieceName;
    }

    public PLAYER_ID getPieceState()
    {
        return pieceState;
    }

    public void setBoardPieceState(PLAYER_ID newPieceState)
    {
        if(this.pieceState == PLAYER_ID.NO_PLAYER &&( newPieceState == PLAYER_ID.PLAYER_ONE || newPieceState == PLAYER_ID.PLAYER_TWO))
            this.pieceState =  newPieceState;
        else
            System.out.println("Incorrect BoardPiece state");
    }

    @Override
    public int compareTo(BoardPiece o)
    {
        return 1;
    }
}
