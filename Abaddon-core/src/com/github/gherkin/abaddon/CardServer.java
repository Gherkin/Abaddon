package com.github.gherkin.abaddon;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.github.gherkin.abaddon.card.Action;
import com.github.gherkin.abaddon.card.Deck;

public class CardServer {
	final Abaddon game;
	Server server;
	boolean ready;
	Deck deck;
	Deck[] playerDeck;
	Deck table;
	Kryo kryo;
	short packet;
	
	public CardServer(final Abaddon gam) {
		ready = false;
		game = gam;
		server = new Server();
		server.start();
		try {
			server.bind(10101, 10101);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(server.getConnections().length > 0) {
			System.out.println(server.getConnections().length);
			ready = true;
			kryo = server.getKryo();
			kryo.register(Deck.class);
			kryo.register(Action.class);
			kryo.register(short.class);
			deck = new Deck(true);
			playerDeck = new Deck[2];
			for(Deck deck : playerDeck)
				deck = new Deck(4);
			table = new Deck();
			while(deck.size() > 0)
				deal();
				server.sendToAllTCP(table);
				for(int i = 0; i < 2; i++)
					server.sendToTCP(i, playerDeck[i]);
				
		}
	}
	
	public void deal() {
		for(int i = 0; i < 2; i++) 
			for(int e = 0; e < 2; e++)
				playerDeck[i].addCard(deck.returnCard(true));
		if(table.size() == 0)
			for(int i = 0; i < 2; i++)
				table.addCard(deck.returnCard(true));
	}
}
