package web.game.people.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

/**
 * Created by Velmont on 2017-07-10.
 */
public class LoadingScreen extends PeopleScreen {
    private float loadingTime = 4f;

    public LoadingScreen(AssetManager assetManager) {
        super(assetManager);
    }

    @Override
    public void initialise(GameContainer gc) {}

    @Override
    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
        if(loadingTime > 0f) {
            loadingTime -= delta;
            if(loadingTime < 0f) {
                //Fade to InGameScreen after 4 seconds
                screenManager.enterGameScreen(ScreenEnum.MAIN.ordinal(), new FadeOutTransition(),
                        new FadeInTransition());

                Music bgm = assetManager.get("sound/bgm/bgm_tam-g15.mp3", Music.class);
                bgm.play();
            }
        }
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        g.drawString("Loading...", 32, 32);
    }

    @Override
    public int getId() {

        return ScreenEnum.LOADING.ordinal();
    }
}