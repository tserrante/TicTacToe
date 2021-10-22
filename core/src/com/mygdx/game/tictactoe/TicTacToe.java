package com.mygdx.game.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;

public class TicTacToe extends ApplicationAdapter
{
	// music and textures
	private Texture image_o;
	private Texture image_x;
	private Texture boardTexture;
	private Sound placePieceSound;
	private Sound roundOverSound;
	private Music gameMusic;
	// camera and spritebatch
	private OrthographicCamera camera;
	private SpriteBatch batch;
	// rectangle object for textures
	private Rectangle r_board;
	private Rectangle r_piece_x;
	private Rectangle r_piece_o;
	// for mouse position
	private Vector3 touchPos;

	@Override
	public void create()
	{
		// load the images for the board and game pieces
		image_o = new Texture(Gdx.files.internal("o.png"));
		image_x = new Texture(Gdx.files.internal("x.png"));
		boardTexture = new Texture(Gdx.files.internal("board.png"));

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

		// setup the board
		r_board = new Rectangle();
		r_board.x = 800/2 - 64/2; // center horizontally
		r_board.y = 480/2 - 64/2; // center vertically
		r_board.width = 256;
		r_board.height = 256;

		// setup the pieces
		r_piece_o = new Rectangle();
		r_piece_o.x = 800/2 - 64/2;
		r_piece_o.y = 50;
		r_piece_o.width = 64;
		r_piece_o.height = 64;

		r_piece_x = new Rectangle();
		r_piece_x.x = 800/2 + 64/2;
		r_piece_x.y = 50;
		r_piece_x.width = 64;
		r_piece_x.height = 64;
	}

	// render the board
	@Override
	public void render()
	{
		// clear the screen
		ScreenUtils.clear(0, 0, 0.2f, 1);
		// update the camera, once per frame
		camera.update();
		// use the coordinates specified by the camera,
		// where camera.combined is a matrix.
		batch.setProjectionMatrix(camera.combined);
		// sprite batch records all drawing commands between begin and end
		batch.begin();
		batch.draw(boardTexture, r_board.x, r_board.y);
		batch.draw(image_o, r_piece_o.x, r_piece_o.y);
		batch.draw(image_x, r_piece_x.x, r_piece_x.y);
		batch.end();

		if(Gdx.input.isTouched())
		{
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			// we will just worry about the x piece now
			r_piece_x.x = touchPos.x - 64 / 2;
			r_piece_x.y = touchPos.x - 64 / 2;

		}

		if(r_piece_x.overlaps(r_board))
		{
			placePieceSound.play();
		}

	}
	@Override
	public void dispose()
	{
		image_o.dispose();
		image_x.dispose();
		boardTexture.dispose();
		placePieceSound.dispose();
		roundOverSound.dispose();
		gameMusic.dispose();
		batch.dispose();
	}
}
