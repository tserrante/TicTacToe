package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class TicTacToe extends Game
{
	private Board board;
	private Player player1;
	private Sound placePieceSound;
	private Sound roundOverSound;
	private Music gameMusic;

	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Vector3 touchPos;

	@Override
	public void create()
	{

		board = new Board();
		player1 = new Player('o', "Player One");


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

		if(Gdx.input.isTouched())
		{
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player1.setPieceRect_H(touchPos.x);
			player1.setPieceRect_V(touchPos.y);
		}

		batch.begin();
		batch.draw(board.getBoardImage(), board.getBoardPos_H(), board.getBoardPos_V());
		batch.draw(player1.getPieceImage(), player1.getPieceRect_H(), player1.getPieceRect_V());
		batch.end();





	}
	@Override
	public void dispose()
	{
		board.disposeBoardImage();
		player1.disposePieceImage();
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
