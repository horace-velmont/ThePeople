package web.game.people.utility;

import com.badlogic.gdx.Gdx;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.serialization.SerializationException;
import org.mini2Dx.ui.element.AlignedModal;

public class XmlModalMaker {
    private static final String XML_UI_PATH = "xml/ui/";
    private static final String FILE_NAME_EXTENTION = "Modal.xml";

    public static AlignedModal makeXmlModal(String modalName){
        AlignedModal modal = null;
        try {
            modal = Mdx.xml.fromXml(Gdx.files.internal(XML_UI_PATH + modalName+ FILE_NAME_EXTENTION).reader(), AlignedModal.class);
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return modal;
    }
}
