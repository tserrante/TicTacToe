package com.mygdx.game.tictactoe;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;




public class TicTacToe extends Game implements InputProcessor, ApplicationListener
{
	private Board board;
	private Player player1;

	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private float posX, posY;


	@Override
	public void create()
	{

		batch = new SpriteBatch();
		board = new Board();
		player1 = new Player("o");

		posX = 0;
		posY = 0;

		// create the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		Gdx.input.setInputProcessor(this);

		board.printBoardMap();

	}

	// render the board
	@Override
	public void render()
	{
		// clear the screen
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		board.setOnBoard(posX, posY, player1);

		board.notifyContaining(player1);

		batch.begin();

		board.drawBoard(batch);
		player1.drawPiece(batch);

		batch.end();
	}
	@Override
	public void dispose()
	{
		player1.disposePiece();
		batch.dispose();
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

