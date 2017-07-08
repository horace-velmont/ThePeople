package web.game.people;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.style.UiTheme;
import web.game.people.gameData.UserData;
import web.game.people.screen.PeopleScreen;

public class PeopleGame extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "web.game.people";
    public AssetManager assetManager;
    public UiContainer uiContainer;

	@Override
    public void initialise() {
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);
        assetManager.setLoader(UiTheme.class, new UiThemeLoader(fileHandleResolver));
        assetManager.load(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class);
        assetManager.load("texture/ui/main/people_header.png", Texture.class);
        di();
        addScreen(new PeopleScreen(assetManager));
    }

    public void di() {
        try {
            Mdx.di.scan(new String[]{"web.game.people.gameData", "web.game.people.model"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getInitialScreenId() {
        return PeopleScreen.ID;
    }
}
