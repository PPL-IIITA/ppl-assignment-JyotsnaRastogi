//sorted array implementation
package couple;

import boy.Boy;
import girl.Girl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Sortedarray extends Find {
      List <Boy> by=new ArrayList<Boy>();
    public void store(List<Boy> boy) {  //to store boy list
        for(Boy b:boy) {
           
            if(!(b.status.equals("Single"))) {
               
                by.add(b);
            }
        }
         
          for(int i=0;i<by.size();i++) {
              for(int j=0;j<by.size()-1;j++) {
                  if(by.get(j).name.compareTo(by.get(j+1).name)>0) {
                      Boy b=by.get(j);
                      by.set(j, by.get(j+1));
                      by.set(j+1,b);
                  }
              }
          }
          
       
    }
    public Girl find(Boy boy) {   //to find girlfreind
            int l,u,mid;
            l=0;
            u=by.size()-1;
      if(by.size()>0) {
          while(l<=u) {
            mid=(u+l)/2;
            if((by.get(mid).name.compareTo(boy.name))==0) {
               
                    return by.get(mid).girl;
            }
                else if((by.get(mid).name.compareTo(boy.name))<0) {
                    l=mid+1;
                }
                else if((by.get(mid).name.compareTo(boy.name))>0)
                    u=mid-1;
            
          }
      }
        return null;
    }
}
