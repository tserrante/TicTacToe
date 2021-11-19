package com.mygdx.game.tictactoe;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Iterator;
import java.util.Arrays;


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

    public PlayerPiece getPiece(int i)    {return pieces[i];}

    public PlayerPiece[] getPlayerPieces()    {return pieces;}


    public void drawPieces(Batch batch)
    {
        for(PlayerPiece piece : pieces)
        {
            piece.draw(batch);
        }
    }

    public PLAYER_ID getPlayerId()
    {
        return playerId;
    }

    public void disposePieceAtlas()
    {
        pieceAtlas.dispose();
    }
}