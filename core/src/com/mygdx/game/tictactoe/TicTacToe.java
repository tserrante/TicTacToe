package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

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


		if(Gdx.input.isTouched())
		{
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player1.setPieceRectX(touchPos.x);
			player1.setPieceRectY(touchPos.y);
		}

		for(int i = 0; i < 9; i++)
		{
			/*
			if(player1.getPieceRect().overlaps(board.getBoardCell(i)))
			{
				System.out.println("Cell " + i + " is overlapped.");
				ScreenUtils.clear(0, 0, 0, 1);
			}
			 */

			if((board.getCellX(i) < player1.getPieceRectX()) && (board.getCellY(i) < player1.getPieceRectY())
				&& (board.getCellX(i) + board.getCellWidth(i) > player1.getPieceRectX() + player1.getPieceRectWidth())
				&& (board.getCellY(i) + board.getCellHeight(i)) > player1.getPieceRectY() + player1.getPieceRectHeight())
			{
				System.out.println("Cell " + i + " is overlapped.");
				ScreenUtils.clear(0, 0, 0, 1);
			}
		}


		batch.begin();
		batch.draw(board.getBoardImage(), board.getBoardPos_H(), board.getBoardPos_V());

		batch.draw(player1.getPieceImage(), player1.getPieceRectX(), player1.getPieceRectY());
		batch.end();


		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(Color.BLACK);
		for(int i = 0; i < 9; i++)
			shape.rect(board.getCellX(i), board.getCellY(i), board.getCellWidth(i), board.getCellHeight(i));
		shape.end();







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
