package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Piece
{
    private Texture texture;
    private Rectangle rect;


    public Piece(Player p, float x, float y)
    {
        if(Character.toUpperCase(p.getPiece()) == 'X')
        {
            texture = new Texture(Gdx.files.internal("x.png"));
        }
        else
        {
            texture = new Texture(Gdx.files.internal("o.png"));
        }

        rect = new Rectangle(x - 32, y - 32, texture.getWidth(), texture.getHeight());


    }

    public void setPieceRectX(float x)
    {
        rect.x = x - 32;
    }
    public void setPieceRectY(float y)
    {
        rect.y = y - 32;
    }

    public float getX()
    {
        return rect.x;
    }
    public float getY()
    {
        return rect.y;
    }
    public float getWidth(){return rect.getWidth();}
    public float getHeight(){return rect.getHeight();}
    public void disposeImage()
    {
        texture.dispose();
    }


    public Texture getImage()
    {
        return texture;
    }
    public Rectangle getRect()
    {
        return rect;
    }

}
