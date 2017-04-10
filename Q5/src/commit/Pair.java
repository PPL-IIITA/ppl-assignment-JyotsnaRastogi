/*class pair for pairing the girls and boys*/
package commit;
import girl.Girl;
import boy.Boy;

import java.util.List;
/**
 * 
 * class pair for pairing the girls and boys
 */
public class Pair {
    public static Boy pairgirl(Girl g,List<Boy> boy) {
        for(Boy b : boy) {
        if(("Single".equals(g.status))&&(g.choose(b)==1)&&("Single".equals(b.status)))
         return b;
        
        }
           return null;
    }
    
    public static Girl pairboy(List<Girl> girl,Boy b) {
        int max=-99999;
        Girl i = null;
        for(Girl g : girl) {
                 if(g.attract>max&&g.status.equals("Single")&&g.mbudget<=b.budget) {
                     max=g.attract;
                     i=g;
                 }
        }
        return i;
    }
    
}
