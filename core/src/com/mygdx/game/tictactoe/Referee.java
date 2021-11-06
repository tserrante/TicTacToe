package com.mygdx.game.tictactoe;


public class Referee
{
    public static boolean isValidMove(Board board, int index)
    {
        return board.getPosition(index) != 'X' && board.getPosition(index) != 'O';
        
    }
}