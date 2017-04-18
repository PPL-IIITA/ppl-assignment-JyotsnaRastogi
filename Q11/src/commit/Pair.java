//class for pairing
package commit;
import Exc.BoyNotFound;
import Exc.GirlNotFound;
import girl.Girl;
import boy.Boy;
import java.util.List;

public class Pair {
    public static int pair(Girl g,Boy b) {       // pairing function
        
        if((g.status=="Single")&&(g.choose(b)==1)&&(b.status=="Single")&&(b.choose(g)==1))
         return 1;
        else
           return 0;
    }
    
    public static Boy pairgirl(Girl g,List<Boy> boy) throws BoyNotFound {
        for(Boy b : boy) {
        if(("Single".equals(g.status))&&(g.choose(b)==1)&&("Single".equals(b.status)))
         return b;
        
        }
        throw new BoyNotFound(g);
          
    }
    
    public static Girl pairboy(List<Girl> girl,Boy b) throws GirlNotFound {
        int max=-99999;
        Girl i = null;
        for(Girl g : girl) {
                 if(g.attract>max&&g.status.equals("Single")&&g.mbudget<=b.budget) {
                     max=g.attract;
                     i=g;
                 }
        }
        if(i==null)
           throw new GirlNotFound(b); 
        return i;
    }
    
    
    
}

