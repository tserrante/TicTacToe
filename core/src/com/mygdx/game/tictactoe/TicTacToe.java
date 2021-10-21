package com.mygdx.game.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class TicTacToe extends ApplicationAdapter
{
	// music and textures
	private Texture piece_o;
	private Texture piece_x;
	private Texture board;
	private Sound placedPiece;
	private Sound roundOver;
	private Music gameMusic;
	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	@Override
	public void create()
	{
		// load the images for the board and game pieces
		piece_o = new Texture(Gdx.files.internal("o.png"));
		piece_x = new Texture(Gdx.files.internal("x.png"));
		board = new Texture(Gdx.files.internal("board.png"));

		// load the sound effects for placing a piece and ending a round
		placedPiece = Gdx.audio.newSound(Gdx.files.internal("clack.wav"));
		roundOver = Gdx.audio.newSound(Gdx.files.internal("bell.wav"));
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
}
