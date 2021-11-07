package com.mygdx.game.tictactoe;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player
{
    char piece;
    String name;

    private Texture pieceImage;
    private Rectangle pieceRect;

    Player() 
    { 
        piece = ' '; 
        name = null;

        pieceImage = null;
        pieceRect = null;
    }

    Player(char piece, String name)
    {
        if(Character.toUpperCase(piece) == 'X' || Character.toUpperCase(piece) == 'O')
        {
            this.piece = Character.toUpperCase(piece);
        }
        else
        {
            System.out.println("Invalid Selection, setting to empty character");
            piece = ' ';
        }

        this.name = name;
        if(this.piece == 'X')
            pieceImage = new Texture(Gdx.files.internal("x.png"));
        else
            pieceImage = new Texture(Gdx.files.internal("o.png"));

        pieceRect = new Rectangle();

    }

    public char getPiece() {return piece;}
    public String getName() {return name;}

    public void setPiece(char piece) 
    {
        if(Character.toUpperCase(piece) == 'X' || Character.toUpperCase(piece) == 'O')
        {
            this.piece = piece;
        }
        else
        {
            System.out.println("Invalid Selection, setting to empty character");
            piece = ' ';
        }    
    }

    public void setName(String name) {this.name = name;}

    public void nextMove(Board board, int index)
    {
        board.setPosition(this, index);
    }

    public void setPieceRect_H(float x)
    {
        pieceRect.x = x - 32;
    }
    public void setPieceRect_V(float y)
    {
        pieceRect.y = y - 32;
    }
    public float getPieceRect_H()
    {
        return pieceRect.x;
    }
    public float getPieceRect_V()
    {
        return pieceRect.y;
    }
    public Rectangle getPieceRect()
    {
        return pieceRect;
    }
    public Texture getPieceImage()
    {
        return pieceImage;
    }

    public void disposePieceImage()
    {
        pieceImage.dispose();
    }
}