package web.game.test.gameData;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.di.BeanUtils;
import org.mini2Dx.core.di.DependencyInjection;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.exception.MdxException;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.desktop.di.DesktopDependencyInjection;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import org.mini2Dx.ui.element.Modal;
import web.game.people.PeopleGame;
import web.game.people.gameData.UserData;
import web.game.test.DummyPeopleGame;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Velmont on 2017-07-08.
 */
public class UserDataTest {
    @Autowired
    private UserData userData;
    private HeadlessMini2DxGame testLauncher;

    @Before
    public void setUp() throws Exception{
        DummyPeopleGame dummyPeopleGame = new DummyPeopleGame();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(UserDataTest.class.getName());
        config.runGame = false;
        testLauncher = new HeadlessMini2DxGame(dummyPeopleGame, config);
        Mdx.di.scan(new String[]{"web.game.people.gameData", "web.game.people.model"});
    }

    @Test
    public void testDependencyInjection(){
        userData = Mdx.di.getBean(UserData.class);
        assertNotNull(userData.getPerson());
    }
}
