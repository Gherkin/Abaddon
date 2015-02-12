package com.github.gherkin.abaddon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

public class Abaddon extends Game {
	SpriteBatch batch;
	Texture cardSheet;
	TextureRegion cardBackground;
	TextureRegion[][] cards;
	CardServer cardServer;
	Client cardClient;
	public MainMenuScreen mainMenu;
	
	public void create () {
		/*cardSheet = new Texture(Gdx.files.internal("cards.png"));
		TextureRegion[][] tmp = TextureRegion.split(cardSheet, cardSheet.getWidth()/13, cardSheet.getHeight()/5);
		cards = new TextureRegion[4][13];
		for(int i = 0; i < 4; i++) {
			for(int e = 0; e < 13; e++) {
				cards[i][e] = tmp[i][e];
			}
		}
		cardBackground = tmp[4][0];
		batch = new SpriteBatch();*/
		mainMenu = new MainMenuScreen(this);
		
		this.setScreen(mainMenu);
	}

	public void render () {
		super.render();
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(cards[3][12], 0, 0);
		batch.end();*/
	}
	
}
