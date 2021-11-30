package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import static com.mygdx.game.tictactoe.Referee.*;

public class GameMaster
{
    private final Board board;
    private final Player player1;
    private final Player player2;

    private float posX, posY;

    public GameMaster()
    {
        board = new Board();
        board.setupBoardPieces();
        player1 = new Player("x", PLAYER_ID.PLAYER_ONE);
        player2 = new Player("o",  PLAYER_ID.PLAYER_TWO);

        posX = 0;
        posY = 0;
    }

    public void play()
    {
        if(Gdx.input.isTouched())
        {
            // check whose turn
            if(player1.getNumTurns() <= player2.getNumTurns())
            {
                if(isValidMove(board.getBoardPiece(posX, posY)))
                {
                    player1.makeMove(board.getBoardPiece(posX, posY));
                    player1.incrementNumTurns();
                }
            }
            else // Player Two's turn
            {
                if(isValidMove(board.getBoardPiece(posX, posY)))
                {
                    player2.makeMove(board.getBoardPiece(posX, posY));
                    player2.incrementNumTurns();
                }
            }
        }
    }

    public boolean isOver()
    {
        return isWinningPlay(board);
    }

    public void winningSequence(GraphicsMaster g)
    {
        g.setDrawPoints(Referee.getWinningPieces(), Referee.getWinType());
        g.drawWinningLine();
    }

    public boolean isTie()
    {
        return board.isBoardFull();
    }

    public void tieSequence(GraphicsMaster graphicsMaster, Batch batch)
    {
        graphicsMaster.writeTieMessage(batch);
    }

    public void draw(Batch batch)
    {
        board.drawBoard(batch);
        player1.drawPieces(batch);
        player2.drawPieces(batch);
    }



    public void setPosX(float posX){this.posX = posX;}

    public void setPosY(float posY){this.posY = posY;}

    public Board getBoard(){return board;}

    public Player getPlayer1(){return player1;}

    public Player getPlayer2(){return player2;}
}
