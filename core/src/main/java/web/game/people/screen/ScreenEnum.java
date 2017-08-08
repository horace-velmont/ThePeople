package web.game.people.screen;

import javafx.stage.Screen;

/**
 * Created by Velmont on 2017-07-10.
 */
public enum ScreenEnum {
    LOADING("loading"), MAIN("main"), SELECT("select");

    public String nameString;
    ScreenEnum(String nameString){
        this.nameString = nameString;
    }
}
