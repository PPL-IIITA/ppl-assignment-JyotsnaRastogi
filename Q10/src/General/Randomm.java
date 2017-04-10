//generic class or template for random value generation from k best values
package General;

import boy.Boy;
import girl.Girl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomm <T> {
     public List<T> ksort(List<T> tt,int k) {  //returns k best valued items
        int i=0; 
        List<T> ret=new ArrayList<T>();
        for(T t:tt) {
             if(i<k) {
                 ret.add(t);
                 i++;
                 
             }
             else
                 break;
         }
        return ret;
    }
      public T choose(List<T> tt) {   // returns random value from k best
        
         Random r=new Random();
         int t=r.nextInt(tt.size());
         
        T to=tt.get(t);
             
                  return to;
    } 
}

