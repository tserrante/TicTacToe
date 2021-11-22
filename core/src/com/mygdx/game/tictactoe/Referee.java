package com.mygdx.game.tictactoe;



import java.util.Map;
import java.util.TreeMap;

public class Referee
{
    public static PLAYER_ID winner;

    public static boolean isWinningPlay(Board board)
    {
        Map<Integer, BoardPiece> boardCopy = new TreeMap<>(board.getBoardMap());

            if(boardCopy.get(1).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(1).getPieceState();
                if(boardCopy.get(2).getPieceState() == checkPlayer && boardCopy.get(3).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(4).getPieceState() == checkPlayer && boardCopy.get(7).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(2).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(2).getPieceState();

                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(8).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(3).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(3).getPieceState();
                if(boardCopy.get(6).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(7).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(4).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(4).getPieceState();

                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(6).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(7).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(7).getPieceState();

                if(boardCopy.get(8).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winner = checkPlayer;
                    return true;
                }
            }


            return false;
    }

    public static PLAYER_ID getWinner()
    {
        return winner;
    }


}