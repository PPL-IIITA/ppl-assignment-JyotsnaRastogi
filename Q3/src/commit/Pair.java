//class for pairing
package commit;
import girl.Girl;
import boy.Boy;

public class Pair {
    public static int pair(Girl g,Boy b) {       // pairing function
        
        if((g.status=="Single")&&(g.choose(b)==1)&&(b.status=="Single")&&(b.choose(g)==1))
         return 1;
        else
           return 0;
    }
}

