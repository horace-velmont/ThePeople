package web.game.people.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import web.game.people.PeopleGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(PeopleGame.GAME_IDENTIFIER);
		config.title = "The People";
		config.width = 540;
		config.height = 960;
		config.vSyncEnabled = true;
		new DesktopMini2DxGame(new PeopleGame(), config);
	}
}
