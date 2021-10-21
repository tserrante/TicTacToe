package com.mygdx.game.tictactoe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.tictactoe.TicTacToe;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Tic-Tac-Toe";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new TicTacToe(), config);
	}
}
