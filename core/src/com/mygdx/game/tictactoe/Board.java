package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.*;
import java.util.TreeSet;


public class Board
{
    private static final TextureAtlas boardAtlas = new TextureAtlas("boardSprites.txt");

    private static final Set<BoardPiece> boardSet = new TreeSet<>();

    private static final float boardWidth = 192f;
    private static final float boardHeight = 192f;

    private static final int windowWidth = Gdx.graphics.getWidth();
    private static final int windowHeight = Gdx.graphics.getHeight();

    private static final float anchorX = (windowWidth / 2.0f) - (boardWidth / 2);
    private static final float anchorY = (windowHeight / 2.0f) - (boardHeight / 2);

    public Board()
    {
        // add sprites to hash map
        Array<TextureAtlas.AtlasRegion> regions = boardAtlas.getRegions();

        for(TextureAtlas.AtlasRegion region : regions)
        {
            Sprite sprite;
            sprite = boardAtlas.createSprite(region.name);
            boardSet.add(new BoardPiece(sprite, region.name));
        }

    }

    public void drawBoard(Batch batch)
    {
        Iterator<BoardPiece> itr = boardSet.iterator();

            for(int i = 0; i < boardSet.size(); i++)
            {
                if(itr.hasNext())
                {
                    BoardPiece piece = itr.next();
                    Sprite sprite = piece.getBoardSprite();

                    if(i < 3)
                    {
                        sprite.setPosition(anchorX + (i * 64), anchorY);
                    }

                    if(i >= 3 && i < 6)
                    {
                        sprite.setPosition((anchorX + (i - 3) * 64), anchorY + 64);
                    }

                    if(i >= 6) // greater than or equal to 6
                    {
                        sprite.setPosition((anchorX + (i - 6) * 64), anchorY + 128);
                    }

                    sprite.draw(batch);
                }

            }

    }


    public void setOnBoard(float x, float y, Player p)
    {
        //Collection<BoardPiece> pieces = boardSprites.values();

        Rectangle tempRectangle;
        for(BoardPiece boardPiece : boardSet)
        {
            tempRectangle = boardPiece.getBoardSprite().getBoundingRectangle();

            if(tempRectangle.contains(x, y))
            {
                p.setPieceX(boardPiece.getBoardSprite().getX() + (boardPiece.getBoardSprite().getWidth()/2));
                p.setPieceY(boardPiece.getBoardSprite().getY() + (boardPiece.getBoardSprite().getHeight()/2));

                if(boardPiece.getPieceState() == PLAYER_ID.NO_PLAYER)
                {
                    boardPiece.setPieceState(p.getPlayerId());
                }
            }
        }
    }


    public Set<BoardPiece> getBoardSet()
    {
        return boardSet;
    }

    public void dispose()
    {
        boardAtlas.dispose();
    }


}
