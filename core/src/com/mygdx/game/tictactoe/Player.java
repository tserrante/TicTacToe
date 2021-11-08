package com.mygdx.game.tictactoe;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    char piece;
    String name;


    private List<Rectangle> playerPieces;
    Player() 
    { 
        piece = ' '; 
        name = null;

        playerPieces = new ArrayList<>();
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

        playerPieces = new ArrayList<>();

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


    public void playPiece(Rectangle r)
    {
        playerPieces.add(r);
    }
    public Rectangle getPlayedPiece(int i)
    {
        return playerPieces.get(i);
    }

    public int getPieceListSize()
    {
        return playerPieces.size();
    }
}