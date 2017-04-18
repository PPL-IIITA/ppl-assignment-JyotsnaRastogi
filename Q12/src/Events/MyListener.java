
package Events;

import boy.Boy;
import gift.Gift;
import girl.Girl;
import java.util.List;

/**
 *
 * MyListener interface for event listener with Handler function
 */
public interface MyListener {
    public void Handler(Girl g,List<Boy> boy,List<Gift> gift);
}
