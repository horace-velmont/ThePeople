package web.game.test.utility;

import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import org.mini2Dx.ui.element.AlignedModal;
import web.game.people.screen.ScreenEnum;
import web.game.people.utility.XmlModalMaker;
import web.game.test.DummyPeopleGame;
import web.game.test.gameData.UserDataTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ModalMakerTest {
    @Before
    public void setUp() throws Exception{
        DummyPeopleGame dummyPeopleGame = new DummyPeopleGame();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(UserDataTest.class.getName());
        config.runGame = false;
        HeadlessMini2DxGame testLauncher = new HeadlessMini2DxGame(dummyPeopleGame, config);
        Mdx.di.scan(new String[]{"web.game.people.gameData", "web.game.people.model"});
    }
    @Test
    public void testMakeModal(){
        AlignedModal modal = XmlModalMaker.makeXmlModal(ScreenEnum.MAIN.nameString);
        assertNotNull(modal);
    }
}
