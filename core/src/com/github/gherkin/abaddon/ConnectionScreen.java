package com.github.gherkin.abaddon;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

public class ConnectionScreen implements Screen {
	final Abaddon game;
	Stage stage;
	BitmapFont font;
	Skin skin;
	TextButton connectButton, cancelButton;
	Label ipLabel;
	TextField ipField;

	Table table;
	
	public ConnectionScreen(final Abaddon gam) {
		this.game = gam;
		stage = new Stage();
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont();
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		connectButton = new TextButton("Connect", skin);
		cancelButton = new TextButton("Cancel", skin);
		ipLabel = new Label("IP Adress", skin);
		ipField = new TextField("", skin);
		table.add(ipLabel);
		table.row();
		table.add(ipField);
		table.row();
		table.add(connectButton);
		table.row(); 
		table.add(cancelButton);
		game.cardClient = new Client();
		game.cardClient.start();
		connectButton.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				try {
					game.cardClient.connect(5000, ipField.getText(), 10101, 10101);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		cancelButton.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new MainMenuScreen(game));
				
			}
			
		});
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		if(game.cardClient.isConnected()) 
			game.setScreen(new GameScreen(game));
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
