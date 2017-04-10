//class implementing generic class or template
package General;

import boy.Boy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 *class implementing generic class or template
 * @param <T> 
 */
public class Template <T> {
   
    
    public List<T> ksort(List<T> tt,int k) {   //returns k best valued items
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
    
    
}
