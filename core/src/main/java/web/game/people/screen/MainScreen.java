package web.game.people.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.TextureRegion;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.serialization.SerializationException;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.element.AlignedModal;
import org.mini2Dx.ui.element.Row;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.style.UiTheme;
import web.game.people.PeopleGame;
import web.game.people.gameData.UserData;

/**
 * Created by Velmont on 2017-07-11.
 */
public class MainScreen extends PeopleScreen {
    private Animation magiAnimation;
    public MainScreen(AssetManager assetManager) {
        super(assetManager);
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

        TextureAtlas magiAtlas = assetManager.get("texture/animation/magi_victory.atlas", TextureAtlas.class);
        magiAnimation = new Animation();
        Array<TextureAtlas.AtlasRegion> magiSprites = magiAtlas.findRegions("magi_victory");
        for(int i=0; magiSprites.size > i ;i++) {
            magiAnimation.addFrame(new Sprite(new TextureRegion(magiSprites.get(i))), 0.15f);
        }

        System.out.println("FRAMES : " +magiAnimation.getNumberOfFrames());
        magiAnimation.setLooping(true);

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
        magiAnimation.update(delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
        uiContainer.interpolate(alpha);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        uiContainer.render(g);
        magiAnimation.draw(g, PeopleGame.GAME_WIDTH * 0.5f, 250);
    }

    @Override
    public int getId() {
        return ScreenEnum.MAIN.ordinal();
    }
}
