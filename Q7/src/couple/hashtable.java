//hashtableimplementation
package couple;

import boy.Boy;
import girl.Girl;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class hashtable extends Find {
    Hashtable<Boy,Girl>  by=new Hashtable<Boy,Girl>();
    
    public void store(List<Boy> boy) {    //to store boy list
        for(Boy b:boy) {
            if(!(b.status.equals("Single"))) {
                 by.put(b,b.girl);
            }
        }
        
    }
    public Girl find(Boy boy) {    //to find girlfriend
       if(by.containsKey(boy))
           return by.get(boy);
        return null;
    }
}
