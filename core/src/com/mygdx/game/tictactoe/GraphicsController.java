package com.mygdx.game.tictactoe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.List;

public class GraphicsController
{
    // for drawing winning line
    private static ShapeRenderer winningLine;
    private static Vector2 point1, point2;

    // for displaying tie message
    private Label tieMessage;
    private BitmapFont font;
    private LabelStyle style;

    public GraphicsController()
    {
        winningLine = new ShapeRenderer();

        point1 = new Vector2();
        point2 = new Vector2();
    }

    public void setDrawPoints(List<BoardPiece> winningPieces, Referee.WIN_TYPE winType)
    {
        if(winType == Referee.WIN_TYPE.ROW)
        {
            point1.set(winningPieces.get(0).getX() - 32.0f, winningPieces.get(0).getY() + 32.0f);
            point2.set(winningPieces.get(2).getX() + 96.0f, winningPieces.get(2).getY() + 32.0f);

        }
        if(winType == Referee.WIN_TYPE.COLUMN)
        {
            point1.set(winningPieces.get(0).getX() + 32.0f, winningPieces.get(0).getY() - 32.0f);
            point2.set(winningPieces.get(2).getX() + 32.0f, winningPieces.get(2).getY() + 96.0f);
        }
        if(winType == Referee.WIN_TYPE.DIAGONAL_TR)
        {
            point1.set(winningPieces.get(0).getX() - 32.0f, winningPieces.get(0).getY() - 32.0f);
            point2.set(winningPieces.get(2).getX() + 96.0f, winningPieces.get(2).getY() + 96.0f);
        }
        if(winType == Referee.WIN_TYPE.DIAGONAL_TL)
        {
            point1.set(winningPieces.get(0).getX() + 96.0f, winningPieces.get(0).getY() - 32.0f);
            point2.set(winningPieces.get(2).getX() - 32.0f, winningPieces.get(2).getY() + 96.0f);
        }
    }

    public void drawWinningLine()
    {
        winningLine.begin(ShapeRenderer.ShapeType.Filled);
        winningLine.setColor(1,0,0,0.1f);
        winningLine.rectLine(point1, point2, 5);
        winningLine.end();
    }

    public void writeTieMessage(Batch batch)
    {
        font = new BitmapFont();
        style = new LabelStyle(font, Color.RED);
        tieMessage = new Label("Tie!", style);
        tieMessage.setFontScale(2);
        tieMessage.setPosition((Gdx.graphics.getWidth() / 2.0f) - 32.0f, Gdx.graphics.getHeight() - 100.0f);
        tieMessage.draw(batch, 1.0f);
    }
}
