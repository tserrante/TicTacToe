package com.mygdx.game.tictactoe;


import java.util.Scanner;

public class Game
{

    static Player player1;
    static Player player2;
    static Scanner userInput;
    
    public static void playGame()
    {
        Board board = new Board();
        System.out.println("~~~Tic-Tac-Toe~~~");
        initializePlayers();
        int turnCount = 1;
        board.printBoard();

        while(!board.isFull())
        {
            System.out.println("Turn: " + turnCount);
            // player 1's turn
            
            Game.playerTurn(player1, board);
            
            // check for win condition
            board.printBoard();

            // player 2's turn
            Game.playerTurn(player2, board);
            
            // check for win condition
            board.printBoard();
            turnCount++;
        }
        System.out.println("Game Over!");
        userInput.close();
    }

    private static void playerTurn(Player currentPlayer, Board board)
    {
        userInput = new Scanner(System.in);
        System.out.println(currentPlayer.getName() + "'s turn.");
        System.out.print("Location: ");
        int playerMove = userInput.nextInt();

        if(Referee.isValidMove(board, playerMove))
            currentPlayer.nextMove(board, playerMove);
        else
            System.out.println("Invalid move, skipping turn.");

        userInput.close();
    }

    private static void initializePlayers()
    {
        userInput = new Scanner(System.in);
        // create player 1
        System.out.print("Player 1, enter your name: ");
        String playerName = userInput.nextLine();
        System.out.print("Enter Your Piece: ");
        String playerPiece = userInput.nextLine();
        player1 = new Player(playerPiece.charAt(0), playerName);
        // create player 2
        System.out.print("Player 2, enter your name: ");
        playerName = userInput.nextLine();
        if(player1.getPiece() == 'X')
        {
            player2 = new Player('O', playerName);
        }
        else
        {
            player2 = new Player('X', playerName);
        }
        userInput.close();
    }
    
}
