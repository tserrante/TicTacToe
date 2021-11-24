package com.mygdx.game.tictactoe;



import java.util.*;

public class Referee
{
    public static PLAYER_ID winner;
    public static List<BoardPiece> winningPieces = new ArrayList<>();

    public static boolean isWinningPlay(Board board)
    {
        Map<Integer, BoardPiece> boardCopy = new TreeMap<>(board.getBoardMap());

        if(boardCopy.get(1).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(1).getPieceState();

                if(boardCopy.get(2).getPieceState() == checkPlayer && boardCopy.get(3).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(1));
                    winningPieces.add(boardCopy.get(2));
                    winningPieces.add(boardCopy.get(3));

                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(1));
                    winningPieces.add(boardCopy.get(5));
                    winningPieces.add(boardCopy.get(9));

                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(4).getPieceState() == checkPlayer && boardCopy.get(7).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(1));
                    winningPieces.add(boardCopy.get(4));
                    winningPieces.add(boardCopy.get(7));
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(2).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(2).getPieceState();

                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(8).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(2));
                    winningPieces.add(boardCopy.get(5));
                    winningPieces.add(boardCopy.get(8));

                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(3).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(3).getPieceState();
                if(boardCopy.get(6).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(3));
                    winningPieces.add(boardCopy.get(6));
                    winningPieces.add(boardCopy.get(9));
                    winner = checkPlayer;
                    return true;
                }
                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(7).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(3));
                    winningPieces.add(boardCopy.get(5));
                    winningPieces.add(boardCopy.get(7));
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(4).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(4).getPieceState();

                if(boardCopy.get(5).getPieceState() == checkPlayer && boardCopy.get(6).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(4));
                    winningPieces.add(boardCopy.get(5));
                    winningPieces.add(boardCopy.get(6));
                    winner = checkPlayer;
                    return true;
                }
            }

            if(boardCopy.get(7).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = boardCopy.get(7).getPieceState();

                if(boardCopy.get(8).getPieceState() == checkPlayer && boardCopy.get(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(boardCopy.get(7));
                    winningPieces.add(boardCopy.get(8));
                    winningPieces.add(boardCopy.get(9));
                    winner = checkPlayer;
                    return true;
                }
            }


            return false;
    }

    public static boolean isValidMove(BoardPiece boardPiece)
    {
        return boardPiece != null && boardPiece.getPieceState() == PLAYER_ID.NO_PLAYER;
    }

    public static PLAYER_ID getWinner()
    {
        return winner;
    }

    public static List<BoardPiece> getWinningPieces()
    {
        return winningPieces;
    }

}