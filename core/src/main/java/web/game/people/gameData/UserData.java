package web.game.people.gameData;

import lombok.Data;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.di.annotation.Singleton;
import web.game.people.model.Person;

/**
 * Created by Velmont on 2017-07-08.
 */
@Singleton
@Data
public class UserData {
    @Autowired
    private Person person;
}
