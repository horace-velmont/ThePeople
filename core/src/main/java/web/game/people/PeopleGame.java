package web.game.people;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.style.UiTheme;
import web.game.people.assets.PeopleAssetLoader;
import web.game.people.screen.LoadingScreen;
import web.game.people.screen.MainScreen;
import web.game.people.screen.PeopleScreen;
import web.game.people.screen.ScreenEnum;

public class PeopleGame extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "web.game.people";
	public static final int GAME_WIDTH = 960;
	public static final int GAME_HEIGHT = 540;
    public AssetManager assetManager;
    public UiContainer uiContainer;

	@Override
    public void initialise() {
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);
        assetManager.setLoader(UiTheme.class, new UiThemeLoader(fileHandleResolver));
        assetManager.load(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class);
        assetManager.load("texture/ui/main/people_header.png", Texture.class);
        assetManager.load("texture/ui/blank/blank_height_150.png", Texture.class);
        PeopleAssetLoader.loadAtlas(assetManager);
        assetManager.load("sound/bgm/bgm_tam-g15.mp3", Music.class);
        assetManager.finishLoading();
        scanDependency();

        addScreen(new LoadingScreen(assetManager));
        addScreen(new MainScreen(assetManager));

    }

    private void scanDependency() {
        try {
            Mdx.di.scan(new String[]{"web.game.people.gameData", "web.game.people.model"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getInitialScreenId() {
        return ScreenEnum.LOADING.ordinal();
    }
}
