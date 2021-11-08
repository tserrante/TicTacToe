package com.mygdx.game.tictactoe;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Board
{
    static final int BOARD_SIZE = 9;
    static final int ASCII_OFFSET = 49;
    private char[] board;
    
    Board()
    {
        // allocate board
        board = new char[BOARD_SIZE];
        int tempBoardMarker;
        // set board to default state
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            tempBoardMarker = ASCII_OFFSET + i;
            board[i] = (char) tempBoardMarker;
        }

    }
    public char getPosition(int index)
    {
        if((index - 1)>= 0 && (index - 1) < BOARD_SIZE)
            return board[index - 1];
        else
            return ' ';
    }
    public void setPosition(Player player, int index)
    {       
        board[index - 1] = player.getPiece();
    }

    public void printBoard()
    {
        System.out.println("+-----------+");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("+-----------+");

    }
    public boolean isFull()
    {
        
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(board[i] != 'X' && board[i] != 'O')
                return false;
        }
        return true;
    }
}
