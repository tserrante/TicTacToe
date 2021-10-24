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

	private Sound placePieceSound;
	private Sound roundOverSound;
	private Music gameMusic;
	// camera and spritebatch
	private OrthographicCamera camera;




	@Override
	public void create()
	{


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
		//batch.setProjectionMatrix(camera.combined);
		// sprite batch records all drawing commands between begin and end


		//if(r_piece_x.overlaps(r_board))
		//{
			placePieceSound.play();
		//}

	}
	@Override
	public void dispose()
	{
		placePieceSound.dispose();
		roundOverSound.dispose();
		gameMusic.dispose();

	}
}
