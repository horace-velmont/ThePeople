package web.game.test;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import lombok.Getter;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by Velmont on 2017-07-08.
 */
public class DummyPeopleGame extends BasicGame {
    @Getter
    private AssetManager assetManager;

    @Override
    public void initialise() {
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager(fileHandleResolver);
    }

    @Override
    public void update(float delta) {}

    @Override
    public void interpolate(float alpha) {}

    @Override
    public void render(Graphics g) {}
}