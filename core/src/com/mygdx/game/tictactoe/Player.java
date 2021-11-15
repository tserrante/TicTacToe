package com.mygdx.game.tictactoe;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class Player
{
    private static final TextureAtlas pieceAtlas = new TextureAtlas("pieceSprites.txt");;
    private Sprite piece;

    private static float pieceWidth = 64;
    private static float pieceHeight = 64;

    private float pieceX, pieceY;

    Player(String pieceSelect)
    {
        // set the users piece here
        //Array<TextureAtlas.AtlasRegion> regions = pieceAtlas.getRegions();
        if(pieceSelect.toLowerCase().equals("x"))
            piece = new Sprite(pieceAtlas.findRegion("piece_" + pieceSelect));
        if(pieceSelect.toLowerCase().equals("o"))
            piece = new Sprite(pieceAtlas.findRegion("piece_" + pieceSelect));

        pieceX = 0;
        pieceY = 0;
    }

    public void setPieceX(float x)    {pieceX = x - (pieceWidth / 2);}

    public void setPieceY(float y)    {pieceY = y - (pieceHeight / 2);}

    public float getPieceX()    {return pieceX;}

    public float getPieceY()    {return pieceY;}

    public static float getPieceHeight()    {return pieceHeight;}

    public static float getPieceWidth()    {return pieceWidth;}

    public Sprite getPiece()    {return piece;}

    public void drawPiece(Batch batch)
    {
        piece.setPosition(pieceX, pieceY);
        piece.draw(batch);
    }

    public void disposePiece()
    {
        pieceAtlas.dispose();
    }
}