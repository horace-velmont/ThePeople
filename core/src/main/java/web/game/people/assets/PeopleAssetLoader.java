package web.game.people.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Velmont on 2017-07-13.
 */
public class PeopleAssetLoader {
    public static void loadAtlas(AssetManager assetManager){
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
