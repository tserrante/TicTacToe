package com.mygdx.game.tictactoe;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Board
{
    static final int BOARD_SIZE = 9;
    static final int ASCII_OFFSET = 49;
    private char[] board;

    private Texture boardImage;
    private Rectangle boardRect;

    private Rectangle[] boardCells;
    
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
        // create texture and rectangle for board
        boardImage = new Texture(Gdx.files.internal("board.png"));
        boardRect = new Rectangle();
        boardRect.x = (Gdx.graphics.getWidth() / 2) - (boardImage.getWidth() / 2);
        boardRect.y = (Gdx.graphics.getHeight() / 2) - (boardImage.getHeight() / 2);

        initializeBoardCells();
    }

    private void initializeBoardCells()
    {
        boardCells = new Rectangle[9];

        for(int i = 0; i < boardCells.length; i++ )
        {
            if(i <= 3)
            {

            }
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

    /**
     * The following methods apply to the board texture only
     */

    public Texture getBoardImage()
    {
        return boardImage;
    }

    public float getBoardPos_H()
    {
        return boardRect.x;
    }
    public float getBoardPos_V()
    {
        return boardRect.y;
    }

    public void disposeBoardImage() {
        boardImage.dispose();
    }
}
