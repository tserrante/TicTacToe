package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends Game
{
	private Board board;
	private Player player1;


	private Sound placePieceSound;
	private Sound roundOverSound;
	private Music gameMusic;

	private ShapeRenderer shape;
	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private final Vector3 touchPos = new Vector3();

	@Override
	public void create()
	{

		board = new Board();
		player1 = new Player('o', "Player One");

		shape = new ShapeRenderer();
		// load the sound effects for placing a piece and ending a round
		placePieceSound = Gdx.audio.newSound(Gdx.files.internal("bell.mp3"));
		roundOverSound = Gdx.audio.newSound(Gdx.files.internal("bell.mp3"));
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("gameMusic.mp3"));

		// loop game music
		gameMusic.setLooping(true);
		gameMusic.play();

		// create the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		// create the sprite batch
		batch = new SpriteBatch();

	}

	// render the board
	@Override
	public void render()
	{
		// clear the screen
		ScreenUtils.clear(1, 1, 1, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		/*
		if(Gdx.input.isTouched())
		{

		}
		*/


		batch.begin();
		// draw board
		//batch.draw();
		// draw pieces played on board

		batch.end();

		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(Color.BLACK);
		for(int i = 0; i < 9; i++)
			//shape.line();
		shape.end();
	}
	@Override
	public void dispose()
	{

		placePieceSound.dispose();
		roundOverSound.dispose();
		gameMusic.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
	}


}

