//library used for 2 type of giftings
package gift;

import boy.Boy;
import java.io.IOException;
import java.util.List;

/**
 * 
 * library used for 2 type of giftings
 */
public abstract class GiftSelector {
     public abstract void gifther(List<Boy> boy,List<Gift> gift) throws IOException;  //gifting function
}
