package web.game.people.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.ui.UiThemeLoader;
import org.mini2Dx.ui.style.UiTheme;

/**
 * Created by Velmont on 2017-07-13.
 */
public class PeopleAssetLoader {
    public static void loadAll(AssetManager assetManager){
        loadUi(assetManager);
        loadAtlas(assetManager);
        loadEtc(assetManager);

        assetManager.finishLoading();
    }
    private  static void loadEtc(AssetManager assetManager){
        assetManager.load("texture/ui/main/people_header.png", Texture.class);
        assetManager.load("texture/ui/blank/blank_height_150.png", Texture.class);
        assetManager.load("sound/bgm/bgm_tam-g15.mp3", Music.class);
    }

    private static void loadUi(AssetManager assetManager){
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager.setLoader(UiTheme.class, new UiThemeLoader(fileHandleResolver));
        assetManager.load(UiTheme.DEFAULT_THEME_FILENAME, UiTheme.class);
    }

    private static void loadAtlas(AssetManager assetManager){
        FileHandle[] atlasArray = Gdx.files.internal("texture/animation").list("atlas");
        for(int i = 0; i< atlasArray.length; i++){
            if(!atlasArray[i].isDirectory()){
                String filePath = atlasArray[i].path();
                assetManager.load(filePath, TextureAtlas.class);
            }
        }
        assetManager.finishLoading();
    }
}
