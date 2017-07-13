package web.game.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.GdxNativesLoader;
import lombok.Getter;
import lombok.Setter;
import org.mini2Dx.core.assets.FallbackFileHandleResolver;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;
import org.mockito.Mockito;

/**
 * Created by Velmont on 2017-07-08.
 */
public class DummyPeopleGame extends BasicGame {
    @Getter@Setter
    private AssetManager assetManager;

    @Override
    public void initialise() {
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
        GdxNativesLoader.load();
        FileHandleResolver fileHandleResolver = new FallbackFileHandleResolver(new ClasspathFileHandleResolver(), new InternalFileHandleResolver());
        assetManager = new AssetManager();
    }

    @Override
    public void update(float delta) {}

    @Override
    public void interpolate(float alpha) {}

    @Override
    public void render(Graphics g) {}
}