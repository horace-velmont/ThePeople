package web.game.people.screen;

import com.badlogic.gdx.assets.AssetManager;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.element.AlignedModal;
import org.mini2Dx.ui.style.UiTheme;
import web.game.people.utility.XmlModalMaker;

public class SelectScreen extends PeopleScreen {
    public SelectScreen(AssetManager assetManager){
        super(assetManager);
    }

    @Override
    public void initialise(GameContainer gc) {
        System.out.println("col");
        uiContainer = new UiContainer(gc, assetManager);
        addModal(ScreenEnum.SELECT.nameString);
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
        uiContainer.render(g);
    }

    @Override
    public int getId() {
        return ScreenEnum.SELECT.ordinal();
    }
}
