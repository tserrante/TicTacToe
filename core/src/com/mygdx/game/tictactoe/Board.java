package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;


import java.util.Map;
import java.util.TreeMap;


public class Board
{
    private static final TextureAtlas boardAtlas = new TextureAtlas("boardSprites.txt");
    private static final TreeMap<Integer, BoardPiece> boardMap = new TreeMap<>();

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
            boardMap.put(index, new BoardPiece(region, region.name));
        }

    }

    public void setupBoardPieces()
    {
        for(Integer index : boardMap.keySet())
        {
            if(index < 4)
            {
                boardMap.get(index).setPosition(anchorX + ((index - 1) * 64), anchorY);
            }

            if(index >= 4 && index < 7)
            {
                boardMap.get(index).setPosition((anchorX + (index - 4) * 64), anchorY + 64);
            }

            if(index >= 7) // greater than or equal to 6
            {
                boardMap.get(index).setPosition((anchorX + (index - 7) * 64), anchorY + 128);
            }
        }
    }

    public void drawBoard(Batch batch)
    {
        for(BoardPiece boardPiece : boardMap.values())
        {
             boardPiece.draw(batch);
        }
    }


    public BoardPiece getBoardPiece(float x, float y)
    {
            for(BoardPiece boardPiece : boardMap.values())
            {
                if(boardPiece.getBoundingRectangle().contains(x ,y))
                    return boardPiece;
            }
            return null;
    }

    public boolean isBoardFull()
    {
        boolean retVal = true;

        for(BoardPiece boardPiece : boardMap.values())
        {
            if (boardPiece.getPieceState() == PLAYER_ID.NO_PLAYER)
            {
                retVal = false;
                break;
            }
        }

        return retVal;
    }
    public Map<Integer, BoardPiece> getBoardMap()
    {
        return boardMap;
    }

    public BoardPiece getBoardPiece(int index)
    {
        try
        {
            return boardMap.get(index);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public void dispose()
    {
        boardAtlas.dispose();
    }


}
