package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class PlayerPiece extends Sprite
{
    private boolean piecePlayed;

    public PlayerPiece(TextureAtlas.AtlasRegion region)
    {
        super(region);
        piecePlayed = false;
        if(region.name.equals("piece_x") )
        {
            setX(0.0f);
            setY(0.0f);
        }
        else
        {
            setX(Gdx.graphics.getWidth() - 64f);
            setY(0);
        }
    }


    public void setPiecePlayed(boolean value) {piecePlayed = value;}
    public boolean isPiecePlayed() {return piecePlayed;}
}
