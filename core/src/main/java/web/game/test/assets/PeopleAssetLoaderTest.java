package web.game.test.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import lombok.Synchronized;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import org.mockito.Mockito;
import web.game.people.assets.PeopleAssetLoader;
import web.game.test.DummyPeopleGame;
import web.game.test.gameData.UserDataTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by Velmont on 2017-07-13.
 */
public class PeopleAssetLoaderTest {
    private DummyPeopleGame  dummyPeopleGame;
    private final String SAMPLE_ASSET_DIRECTORY = "texture/animation";
    private final String SAMPLE_ASSET_NAME = "magi_victory";
    private final String SAMPLE_ASSET_SUFFIX = "atlas";
    private final String SAMPLE_ASSET_PATH = SAMPLE_ASSET_DIRECTORY + "/" + SAMPLE_ASSET_NAME + "." + SAMPLE_ASSET_SUFFIX;

    @Before
    public void setUp() throws Exception{
        dummyPeopleGame = new DummyPeopleGame();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(PeopleAssetLoader.class.getName());
        Gdx.gl = mock(GL20.class);
        config.runGame = false;
        new HeadlessMini2DxGame(dummyPeopleGame, config);
    }

    @Test
    public void testIsInternalPathAvailable(){
        assertTrue(Gdx.files.internal(SAMPLE_ASSET_DIRECTORY).exists());
    }

    @Test
    public void testIsSuffixMethodUsingRight(){
        FileHandle[] atlasFileArray = Gdx.files.internal(SAMPLE_ASSET_DIRECTORY).list(SAMPLE_ASSET_SUFFIX);
        String atlasFilePath = null;
        for(int i = 0; i< atlasFileArray.length; i++){
            if(!atlasFileArray[i].isDirectory()){
                atlasFilePath = atlasFileArray[i].path();
            }
        }
        assertThat(atlasFilePath, is(SAMPLE_ASSET_PATH));
    }
}
