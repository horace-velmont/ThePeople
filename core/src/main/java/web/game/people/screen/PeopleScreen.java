package web.game.people.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
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

/**
 * Created by Velmont on 2017-07-03.
 */
public class PeopleScreen extends BasicGameScreen {
    public static int ID = 0;
    private AssetManager assetManager;
    private UiContainer uiContainer;
    @Autowired
    private UserData userData;

    public PeopleScreen(AssetManager assetManager){
        this.assetManager = assetManager;
    }

    @Override
    public void initialise(GameContainer gc) {
        Gdx.app.log("Test", "Played Initialize");
        uiContainer = new UiContainer(gc, assetManager);
        try {

            AlignedModal modal = Mdx.xml.fromXml(Gdx.files.internal("xml/ui/mainModal.xml").reader(), AlignedModal.class);
            uiContainer.add(modal);
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        userData = Mdx.di.getBean(UserData.class);
        System.out.println(userData);
        System.out.println(userData.getPerson().getAge());
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        if(!assetManager.update()) {
            //Wait for asset manager to finish loading assets
            return;
        }
        if(!uiContainer.isThemeApplied()) {
            uiContainer.setTheme(assetManager.get(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class));
        }
        uiContainer.update(delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
        uiContainer.interpolate(alpha);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        g.drawString("PeopleGame", 40, 40);
        uiContainer.render(g);
    }

    @Override
    public int getId() {
        return PeopleScreen.ID;
    }
}
