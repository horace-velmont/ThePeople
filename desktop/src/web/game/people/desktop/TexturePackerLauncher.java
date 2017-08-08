package web.game.people.desktop;


import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.io.IOException;

/**
 * Created by Velmont on 2017-07-11.
 */
public class TexturePackerLauncher {
    public static void main (String[] args) throws IOException {
        TexturePacker.process("assets/texture/animation", "assets/texture/animation", "magi_victory");
    }
}
