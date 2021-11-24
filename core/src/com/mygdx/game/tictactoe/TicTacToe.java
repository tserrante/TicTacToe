package com.mygdx.game.tictactoe;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Map;

import static com.mygdx.game.tictactoe.Referee.*;


public class TicTacToe extends Game implements InputProcessor, ApplicationListener
{
	private Board board;
	private Player player1;
	private Player player2;

	ShapeRenderer strikeThrough;
	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private float posX, posY;


	@Override
	public void create()
	{

		batch = new SpriteBatch();
		board = new Board();
		player1 = new Player("x", PLAYER_ID.PLAYER_ONE);
		player2 = new Player("o",  PLAYER_ID.PLAYER_TWO);

		posX = 0;
		posY = 0;

		strikeThrough = new ShapeRenderer();

		// create the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		Gdx.input.setInputProcessor(this);

		for(Map.Entry<Integer, BoardPiece> entry : board.getBoardMap().entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue().getBoardPieceName());

	}

	// render the board
	@Override
	public void render()
	{
		// clear the screen
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		if(Gdx.input.isTouched())
		{
			if(isValidMove(board.getBoardPiece(posX, posY)))
				player1.makeMove(board.getBoardPiece(posX, posY));

		}

		batch.begin();
		board.drawBoard(batch);
		player1.drawPieces(batch);
		batch.end();

		if(isWinningPlay(board))
		{
			strikeThrough.begin(ShapeRenderer.ShapeType.Line);
			strikeThrough.setColor(1, 0, 0, 1); // red line
			strikeThrough.line
					(
					getWinningPieces().get(0).getX() + 32f,
					getWinningPieces().get(0).getY() + 32f,
					getWinningPieces().get(2).getX() + 32f,
					getWinningPieces().get(2).getY() + 32f
					);
			strikeThrough.end();
		}

	}
	@Override
	public void dispose()
	{
		player1.disposePieceAtlas();
		player2.disposePieceAtlas();
		strikeThrough.dispose();
		batch.dispose();
	}
	@Override
	public void pause()
	{

	}
	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
	}


	@Override
	public boolean keyDown(int keycode)	{return false;}

	@Override
	public boolean keyUp(int keycode)	{return false;}

	@Override
	public boolean keyTyped(char character)	{return false;}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		if(button == Input.Buttons.LEFT)
		{
			posX = (float)screenX;
			posY = (float)(Gdx.graphics.getHeight() - screenY);
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)	{return false;}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)	{return false;}

	@Override
	public boolean mouseMoved(int screenX, int screenY)	{return false;}

	@Override
	public boolean scrolled(float amountX, float amountY) {return false;}
}

