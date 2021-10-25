package com.mygdx.game.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

public class TicTacToe extends ApplicationAdapter
{

	private ShapeRenderer shape;
	//private Square gameBoard;
	private GameBoard board;
	private ArrayList<Square> squares = new ArrayList<>();

	// variables for creating list of squares

	@Override
	public void create()
	{
		shape = new ShapeRenderer();
		//gameBoard = new Square();

		for(int i = 1; i <= 9; i++)
		{
			// build first row
			if(i <= 3 )
			{
				Square s = new Square(GameBoard.getXoffset() + (i * GameBoard.getSquareWidth()),
																			GameBoard.getYoffset());
				squares.add(s);
			}
			if(i > 3 && i <= 6)
			{
				Square s = new Square(GameBoard.getXoffset() + (GameBoard.getSquareWidth() * (i-3)),
						GameBoard.getYoffset() + GameBoard.getSquareHeight());
				squares.add(s);
			}
			if(i > 6)
			{
				Square s = new Square(GameBoard.getXoffset() + (GameBoard.getSquareWidth() * (i-6)),
						GameBoard.getYoffset() + (GameBoard.getSquareHeight() * 2));
				squares.add(s);
			}

		}

	}

	// render the board
	@Override
	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Line);
		//gameBoard.draw(shape);
		for(Square s : squares)
			s.draw(shape);
		shape.end();
	}
	@Override
	public void dispose()
	{

	}
}
