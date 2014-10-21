package com.github.gherkin.abaddon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
	final Abaddon game;
	Texture cardSheet;
	TextureRegion[][] cards;
	TextureRegion cardBackground;
	Stage stage;
	
	public GameScreen(final Abaddon gam) {
		stage = new Stage();
		game = gam;
		cardSheet = new Texture(Gdx.files.internal("cards.png"));
		TextureRegion[][] tmp = TextureRegion.split(cardSheet, cardSheet.getWidth()/13, cardSheet.getHeight()/5);
		cards = new TextureRegion[4][13];
		for(int i = 0; i < 4; i++) {
			for(int e = 0; e < 13; e++) {
				cards[i][e] = tmp[i][e];
			}
		}
		cardBackground = tmp[4][0];
	}
	@Override
	public void render(float delta) {
		stage.draw();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
