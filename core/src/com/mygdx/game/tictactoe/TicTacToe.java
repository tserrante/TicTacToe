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
	GameMaster game;
	GraphicsMaster graphicsMaster;
	ShapeRenderer strikeThrough;
	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;




	@Override
	public void create()
	{

		batch = new SpriteBatch();
		game = new GameMaster();
		graphicsMaster = new GraphicsMaster();
		strikeThrough = new ShapeRenderer();

		// create the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		Gdx.input.setInputProcessor(this);

	}

	// render the board
	@Override
	public void render()
	{
		// clear the screen
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		game.play();

		batch.begin();
		game.draw(batch);
		if(game.isTie())
		{
			game.tieSequence(graphicsMaster, batch);
		}
		batch.end();

		if(game.isOver())
		{
			game.winningSequence(graphicsMaster);
		}


	}
	@Override
	public void dispose()
	{
		game.getPlayer1().disposePieceAtlas();
		game.getPlayer2().disposePieceAtlas();
		game.getBoard().dispose();
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
			game.setPosX((float)screenX);
			game.setPosY((float)(Gdx.graphics.getHeight() - screenY));
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

