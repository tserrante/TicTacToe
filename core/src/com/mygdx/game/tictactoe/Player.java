package com.mygdx.game.tictactoe;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Player
{
    private static final TextureAtlas pieceAtlas = new TextureAtlas("pieceSprites.txt");
    private PlayerPiece[] pieces;
    private PLAYER_ID playerId;

    Player(String pieceSelect, PLAYER_ID playerId)
    {
        this.playerId = playerId;
        // set the users piece here
        pieces = fillPlayerPieces(pieceSelect);

    }


    private PlayerPiece[] fillPlayerPieces(String pieceSelect)
    {
        PlayerPiece[] retArray = new PlayerPiece[5];
        try
        {
            int count = 0;
            while (count < 5)
            {
                retArray[count] = (new PlayerPiece(pieceAtlas.findRegion("piece_" + pieceSelect)));
                count++;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return retArray;

    }


    public void drawPieces(Batch batch)
    {
        for(PlayerPiece piece : pieces)
        {
            piece.draw(batch);
        }
    }

    public void makeMove(BoardPiece boardPiece)
    {
        boolean madePlay = false;
        for(PlayerPiece playerPiece : pieces)
        {
            if(!playerPiece.isPiecePlayed() && !madePlay)
            {
                playerPiece.setPiecePlayed(true);
                playerPiece.setPosition
                        (
                        boardPiece.getX() + (boardPiece.getWidth() / 2) - 32,
                        boardPiece.getY() + (boardPiece.getHeight() / 2) - 32
                        );
                boardPiece.setBoardPieceState(this.getPlayerId());
                madePlay = true;
            }
        }
    }


    public PlayerPiece[] getPlayerPieces()    {return pieces;}

    public PlayerPiece getPiece(int i)    {return pieces[i];}

    public PLAYER_ID getPlayerId()
    {
        return playerId;
    }

    public void disposePieceAtlas()
    {
        pieceAtlas.dispose();
    }
}