
package Events;

import boy.Boy;
import gift.Gift;
import girl.Girl;
import java.util.List;

/**
 *
 * New girl in town event handles addition of new firl using Handler and triggers handlers of all single boys
 */
public class Newgirl implements MyListener {
    public void Handler(Girl g,List<Boy> boy,List<Gift> gift) {
        for(Boy b:boy) {
            if(b.status.equals("Single")) {
            b.handler(g);
            if(g.status.equals("commited")) {
                return;
            }
        }
        
       }
          if(g.status.equals("Single"))
                         
                         System.out.println(g.name+" could not find someone based on her choice ");
                    
                   
        
    }
}
