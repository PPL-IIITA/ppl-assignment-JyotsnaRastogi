//class for array implementation of boy list
package couple;

import boy.Boy;
import girl.Girl;
import java.util.ArrayList;
import java.util.List;


public class Array extends Find {
    List <Boy> by=new ArrayList<Boy>();
    int i=0;
    public void store(List<Boy> boy) {
        for(Boy b:boy) {
           
            if(b.status.equals("committed")) {
                if(b!=null) {
                by.add(i,b);
                i++;
                }
            }
        }
        
    }
    public Girl find(Boy boy) {
        for(Boy b:by) {
            if(b.name.equals(boy.name)) {
                return b.girl;
            }
        }
        return null;
    }
}
