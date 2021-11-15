package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.*;


public class Board
{
    private static final TextureAtlas boardAtlas = new TextureAtlas("boardSprites.txt");
    private static final TreeMap<String, BoardPiece> boardSprites = new TreeMap<>();


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
            boardSprites.put(region.name, new BoardPiece(sprite, region.name));
        }

    }


    public void drawSprite(Batch batch, String name, float x, float y)
    {
        Sprite sprite = boardSprites.get(name).getBoardSprite();

        sprite.setPosition(x, y);

        sprite.draw(batch);
    }

    public void drawBoard(Batch batch)
    {
        drawSprite(batch, "7-bottomLeft", anchorX, anchorY);
        drawSprite(batch,"8-bottomCenter", anchorX + 64, anchorY);
        drawSprite(batch,"9-bottomRight", anchorX + 128, anchorY);
        drawSprite(batch,"4-middleLeft", anchorX, anchorY + 64);
        drawSprite(batch,"5-middleCenter", anchorX + 64, anchorY + 64);
        drawSprite(batch,"6-middleRight", anchorX + 128, anchorY + 64);
        drawSprite(batch,"1-topLeft", anchorX, anchorY + 128);
        drawSprite(batch,"2-topCenter", anchorX + 64, anchorY + 128);
        drawSprite(batch,"3-topRight", anchorX + 128, anchorY + 128);
    }

    public void dispose()
    {
        boardAtlas.dispose();
    }

    public void setOnBoard(float x, float y, Player p)
    {
        Collection<BoardPiece> pieces = boardSprites.values();

        Rectangle tempRectangle;
        for(BoardPiece boardPiece : pieces)
        {
            tempRectangle = boardPiece.getBoardSprite().getBoundingRectangle();

            if(tempRectangle.contains(x, y))
            {
                p.setPieceX(boardPiece.getBoardSprite().getX() + (boardPiece.getBoardSprite().getWidth()/2));
                p.setPieceY(boardPiece.getBoardSprite().getY() + (boardPiece.getBoardSprite().getHeight()/2));
            }
        }
    }

    public void printBoardMap()
    {
        Set<String> keyList = boardSprites.keySet();

        for(String s : keyList)
        {
            System.out.println(s);
        }
    }
    /*
    public void notifyContaining(Player p)
    {
        Set<String> keys = boardSprites.keySet();
        Rectangle tempRectangle;

        for(String s : keys)
        {

            tempRectangle = new Rectangle(boardSprites.get(s).getBoardSprite().getBoundingRectangle());

            if(p.getPiece().getBoundingRectangle().overlaps(tempRectangle))
            {
                System.out.println(tempRectangle.toString());

                System.out.println(s + " is occupied!");
            }
        }

    }
     */
}
