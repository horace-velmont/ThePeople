package web.game.people.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.serialization.SerializationException;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.element.AlignedModal;
import org.mini2Dx.ui.style.UiTheme;
import web.game.people.PeopleGame;
import web.game.people.gameData.UserData;
import web.game.people.utility.XmlModalMaker;

/**
 * Created by Velmont on 2017-07-03.
 */
public abstract class PeopleScreen extends BasicGameScreen {
    protected AssetManager assetManager;
    protected UiContainer uiContainer;
    @Autowired
    protected UserData userData;
    protected AlignedModal modal;

    public PeopleScreen(AssetManager assetManager){
        this.assetManager = assetManager;
    }

    protected void addModal(String modalName){
        modal = XmlModalMaker.makeXmlModal(modalName);
        uiContainer.add(modal);
    }
}
