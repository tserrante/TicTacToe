package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.Collection;
import java.util.HashMap;

public class Board
{
    private static final TextureAtlas boardAtlas = new TextureAtlas("boardSprites.txt");
    private static final HashMap<String, Sprite> boardSprites = new HashMap<>();
    private int[] boardData;

    private static float boardWidth = 192f;
    private static float boardHeight = 192f;

    private static int windowWidth = Gdx.graphics.getWidth();
    private static int windowHeight = Gdx.graphics.getHeight();

    private static float anchorX = (windowWidth / 2) - (boardWidth / 2);
    private static float anchorY = (windowHeight / 2) - (boardHeight / 2);

    public Board()
    {
        // add sprites to hash map
        Array<TextureAtlas.AtlasRegion> regions = boardAtlas.getRegions();

        for(TextureAtlas.AtlasRegion region : regions)
        {
            Sprite sprite;
            sprite = boardAtlas.createSprite(region.name);
            boardSprites.put(region.name, sprite);
        }
        boardData = new int[9];
        for(int i = 0; i < 9; i++)
        {
            boardData[i] = 0;
        }
    }


    public void drawSprite(Batch batch, String name, float x, float y)
    {
        Sprite sprite = boardSprites.get(name);

        sprite.setPosition(x, y);

        sprite.draw(batch);
    }

    public void drawBoard(Batch batch)
    {
        drawSprite(batch, "bottomLeft", anchorX, anchorY);
        drawSprite(batch,"bottomCenter", anchorX + 65, anchorY);
        drawSprite(batch,"bottomRight", anchorX + 129, anchorY);
        drawSprite(batch,"middleLeft", anchorX, anchorY + 63);
        drawSprite(batch,"middleCenter", anchorX + 65, anchorY + 63);
        drawSprite(batch,"middleRight", anchorX + 129, anchorY + 63);
        drawSprite(batch,"topLeft", anchorX, anchorY + 127);
        drawSprite(batch,"topCenter", anchorX + 65, anchorY + 127);
        drawSprite(batch,"topRight", anchorX + 129, anchorY + 127);
    }

    public void dispose()
    {
        boardAtlas.dispose();
    }

    public void setOnBoard(float x, float y, Player p)
    {
        Collection<Sprite> pieces = boardSprites.values();
        Rectangle tempRectangle;
        for(Sprite s : pieces)
        {
            tempRectangle = s.getBoundingRectangle();

            if(tempRectangle.contains(x, y))
            {
                p.setPieceX(s.getX() + (s.getWidth()/2));
                p.setPieceY(s.getY() + (s.getHeight()/2));
            }
        }


    }

    public void overlapWithPiece()
    {

    }

}
