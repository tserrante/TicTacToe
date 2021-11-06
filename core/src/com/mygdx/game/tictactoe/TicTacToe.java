package com.mygdx.game.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class TicTacToe extends ApplicationAdapter
{

	// music and textures
	private Texture boardImage;
	private Rectangle board;

	private Texture pieceImage_x;
	private Rectangle pieceX;


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
		// load the images for the board and game pieces
		boardImage = new Texture(Gdx.files.internal("board.png"));
		board = new Rectangle();

		board.x = (Gdx.graphics.getWidth() / 2) - (boardImage.getWidth() / 2);
		board.y = (Gdx.graphics.getHeight() / 2) - (boardImage.getHeight() / 2);

		pieceImage_x = new Texture(Gdx.files.internal("x.png"));
		pieceX = new Rectangle();

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
			pieceX.x = touchPos.x - 64 / 2;
			pieceX.y = touchPos.y - 64 / 2;
		}

		batch.begin();
		batch.draw(boardImage, board.x, board.y);
		batch.draw(pieceImage_x, pieceX.x, pieceX.y);
		batch.end();





	}
	@Override
	public void dispose()
	{
		boardImage.dispose();
		pieceImage_x.dispose();
		placePieceSound.dispose();
		roundOverSound.dispose();
		gameMusic.dispose();
		batch.dispose();
	}
}
