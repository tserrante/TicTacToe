package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


import java.util.*;


public class Board
{
    private static final TextureAtlas boardAtlas = new TextureAtlas("boardSprites.txt");
    private static final TreeMap<Integer, BoardPiece> boardSet = new TreeMap<>();

    //used to build the board for draw calls
    private static final float anchorX = (Gdx.graphics.getWidth() / 2.0f) - (192f / 2);
    private static final float anchorY = (Gdx.graphics.getHeight() / 2.0f) - (192f / 2);

    public Board()
    {
        // add sprites to hash map
        Array<TextureAtlas.AtlasRegion> regions = boardAtlas.getRegions();
        int index;

        for(TextureAtlas.AtlasRegion region : regions)
        {
            index = Integer.parseInt(region.name.substring(0,1));
            boardSet.put(index, new BoardPiece(region, region.name));
        }

    }

    public void drawBoard(Batch batch)
    {
        for(Integer index : boardSet.keySet())
        {
            Sprite sprite = boardSet.get(index);
            if(index < 4)
            {
                sprite.setPosition(anchorX + ((index - 1) * 64), anchorY);
            }

            if(index >= 4 && index < 7)
            {
                sprite.setPosition((anchorX + (index - 4) * 64), anchorY + 64);
            }

            if(index >= 7) // greater than or equal to 6
            {
                sprite.setPosition((anchorX + (index - 7) * 64), anchorY + 128);
            }
            sprite.draw(batch);
        }

    }


    public void setOnBoard(float x, float y, Player p)
    {
        Rectangle tempRectangle;
        boolean madePlay = false;

        for(BoardPiece boardPiece : boardSet.values())
        {
            tempRectangle = boardPiece.getBoundingRectangle();

                if (tempRectangle.contains(x, y))
                {
                    for(PlayerPiece piece : p.getPlayerPieces())
                    {
                        if(!piece.isPiecePlayed() && boardPiece.getPieceState() == PLAYER_ID.NO_PLAYER && !madePlay)
                        {
                            piece.setPiecePlayed(true);

                            piece.setPosition
                            (
                                boardPiece.getX() + (boardPiece.getWidth() / 2) - 32,
                                boardPiece.getY() + (boardPiece.getHeight() / 2) - 32
                            );
                            boardPiece.setBoardPieceState(p.getPlayerId());
                            madePlay = true;
                        }
                    }
                }
        }
    }


    public Map<Integer, BoardPiece> getBoardMap()
    {
        return boardSet;
    }

    public void dispose()
    {
        boardAtlas.dispose();
    }


}
