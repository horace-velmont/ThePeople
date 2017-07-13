package web.game.test.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.backends.headless.HeadlessMini2DxGame;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import lombok.Synchronized;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.headless.HeadlessMini2DxConfig;
import org.mockito.Mockito;
import web.game.people.assets.PeopleAssetLoader;
import web.game.test.DummyPeopleGame;
import web.game.test.gameData.UserDataTest;

import javax.xml.soap.Text;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Velmont on 2017-07-13.
 */
public class PeopleAssetLoaderTest {
    private DummyPeopleGame dummyPeopleGame;
    private final String SAMPLE_ASSET_DIRECTORY = "texture/animation";
    private final String SAMPLE_ASSET_NAME = "magi_victory";
    private final String SAMPLE_ASSET_SUFFIX = "atlas";
    private final String SAMPLE_ASSET_PATH = SAMPLE_ASSET_DIRECTORY + "/" + SAMPLE_ASSET_NAME + "." + SAMPLE_ASSET_SUFFIX;

    @Before
    public void setUp() throws Exception{
        dummyPeopleGame = new DummyPeopleGame();
        HeadlessMini2DxConfig config = new HeadlessMini2DxConfig(PeopleAssetLoader.class.getName());
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
        for(int i = 0; i< atlasFileArray.length; i++)   {
            if(!atlasFileArray[i].isDirectory()){
                atlasFilePath = atlasFileArray[i].path();
            }
        }
        assertThat(atlasFilePath, is(SAMPLE_ASSET_PATH));
    }

    @Test
    public void testLoadAtlas(){
        AssetManager assetManager = dummyPeopleGame.getAssetManager();
        //Before Loading
        assertFalse(assetManager.isLoaded(SAMPLE_ASSET_PATH, TextureAtlas.class));

        //After Loading
        PeopleAssetLoader.loadAtlas(assetManager);
        assertTrue(assetManager.isLoaded(SAMPLE_ASSET_PATH, TextureAtlas.class));
    }

}
