//class for sorting
package General;

import boy.Boy;
import gift.Gift;
import girl.Girl;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 
 * class for sorting
 */

public class Sort {
    public void bsort(List<Boy> boy) {   //sorting boys
          if(boy.size()> 0) {
             Collections.sort(boy, new Comparator<Boy>() {
             @Override
             public int compare(final Boy boy1, final Boy boy2) {
              return (int) (-(boy2.attract-(boy1.attract)));
                }
            });
        }
    }
    public Boy choose(List<Boy> boy,Girl g) {   //choosing boys
          if(boy.size()> 0) {
             Collections.sort(boy, new Comparator<Boy>() {
             @Override
             public int compare(final Boy boy1, final Boy boy2) {
              return (int) (-(boy2.budget-(boy1.budget)));
                }
            });
        }
          for(Boy b:boy) {
              if(b.status.equals("Single")&&g.mbudget<=b.budget)
                  return b;
          }
       return null;
    } 
    public void gsort(List<Girl> girl) {   //sorting girls
         if(girl.size()> 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             @Override
             public int compare(final Girl girl1, final Girl girl2) {
              return (int) (-(girl2.attract-(girl1.attract)));
                }
            });
        }
    }
    
    public Girl choose(List<Girl> girl,Boy b) {   //choosing girl
        if(girl.size()> 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             @Override
             public int compare(final Girl girl1, final Girl girl2) {
              return (int) (-(girl1.mbudget-(girl2.mbudget)));
                }
            });
        }
           for(Girl g:girl) {
              if(g.status.equals("Single")&&g.mbudget<=b.budget)
                  return g;
          }
       return null;
    }
    
    public void gifsort(List<Gift> gift) {  //sorting gifts
          if(gift.size()> 0) {
             Collections.sort(gift, new Comparator<Gift>() {
             @Override
             public int compare(final Gift gift1, final Gift gift2) {
              return (int) (-(gift1.price-(gift2.price)));
                }
            });
        }
    }
    
    
}
