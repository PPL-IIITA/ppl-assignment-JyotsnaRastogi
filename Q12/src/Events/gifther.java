
package Events;

import boy.Boy;
import girl.Girl;
import java.util.List;
import gift.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * event for gifting handles gifting using handler function
 */
public class gifther implements MyListener {
    public void Handler(Girl g,List<Boy> boy,List<Gift> gift) {
        gifting gif=new gifting();
        try {
            gif.gifther(g.boy,gift,boy);
        } catch (IOException ex) {
            Logger.getLogger(gifther.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
