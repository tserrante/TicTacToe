package com.mygdx.game.tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Referee
{
    private static PLAYER_ID winner;
    private static final List<BoardPiece> winningPieces = new ArrayList<>();
    public enum WIN_TYPE {ROW, COLUMN, DIAGONAL_TR, DIAGONAL_TL}
    private static WIN_TYPE winType;

    public static boolean isWinningPlay(Board board)
    {
        if(board.getBoardPiece(1).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = board.getBoardPiece(1).getPieceState();

                if(board.getBoardPiece(2).getPieceState() == checkPlayer
                        && board.getBoardPiece(3).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(1));
                    winningPieces.add(board.getBoardPiece(2));
                    winningPieces.add(board.getBoardPiece(3));
                    winType = WIN_TYPE.ROW;
                    winner = checkPlayer;
                    return true;
                }
                if(board.getBoardPiece(5).getPieceState() == checkPlayer && board.getBoardPiece(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(1));
                    winningPieces.add(board.getBoardPiece(5));
                    winningPieces.add(board.getBoardPiece(9));
                    winType = WIN_TYPE.DIAGONAL_TR;
                    winner = checkPlayer;
                    return true;
                }
                if(board.getBoardPiece(4).getPieceState() == checkPlayer && board.getBoardPiece(7).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(1));
                    winningPieces.add(board.getBoardPiece(4));
                    winningPieces.add(board.getBoardPiece(7));
                    winType = WIN_TYPE.COLUMN;
                    winner = checkPlayer;
                    return true;
                }
            }

            if(board.getBoardPiece(2).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = board.getBoardPiece(2).getPieceState();

                if(board.getBoardPiece(5).getPieceState() == checkPlayer && board.getBoardPiece(8).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(2));
                    winningPieces.add(board.getBoardPiece(5));
                    winningPieces.add(board.getBoardPiece(8));
                    winType = WIN_TYPE.COLUMN;
                    winner = checkPlayer;
                    return true;
                }
            }

            if(board.getBoardPiece(3).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = board.getBoardPiece(3).getPieceState();
                if(board.getBoardPiece(6).getPieceState() == checkPlayer && board.getBoardPiece(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(3));
                    winningPieces.add(board.getBoardPiece(6));
                    winningPieces.add(board.getBoardPiece(9));
                    winner = checkPlayer;
                    winType = WIN_TYPE.COLUMN;
                    return true;
                }
                if(board.getBoardPiece(5).getPieceState() == checkPlayer && board.getBoardPiece(7).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(3));
                    winningPieces.add(board.getBoardPiece(5));
                    winningPieces.add(board.getBoardPiece(7));
                    winType = WIN_TYPE.DIAGONAL_TL;
                    winner = checkPlayer;
                    return true;
                }
            }

            if(board.getBoardPiece(4).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = board.getBoardPiece(4).getPieceState();

                if(board.getBoardPiece(5).getPieceState() == checkPlayer && board.getBoardPiece(6).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(4));
                    winningPieces.add(board.getBoardPiece(5));
                    winningPieces.add(board.getBoardPiece(6));
                    winType = WIN_TYPE.ROW;
                    winner = checkPlayer;
                    return true;
                }
            }

            if(board.getBoardPiece(7).getPieceState() != PLAYER_ID.NO_PLAYER)
            {
                PLAYER_ID checkPlayer = board.getBoardPiece(7).getPieceState();

                if(board.getBoardPiece(8).getPieceState() == checkPlayer && board.getBoardPiece(9).getPieceState() == checkPlayer)
                {
                    winningPieces.add(board.getBoardPiece(7));
                    winningPieces.add(board.getBoardPiece(8));
                    winningPieces.add(board.getBoardPiece(9));
                    winType = WIN_TYPE.ROW;
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

    public static WIN_TYPE getWinType()
    {
        return winType;
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