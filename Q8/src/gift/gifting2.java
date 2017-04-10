//for 2nd type of gifting
package gift;

import boy.Boy;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class gifting2 extends GiftSelector {
     public float compatibility(Boy b,float sum) { /*function for finding compatibility of each couple*/
       
        float comp=sum-b.girl.mbudget+abs(b.girl.attract-b.attract)+abs(b.girl.itg-b.itg);
        return comp;
    }
     public void gifther(List<Boy> boy,List<Gift> gift) throws IOException { //function for 2nd type of gifting
          String file="src\\gifting.txt";
          
                 
          if(gift.size()> 0) {
             Collections.sort(gift, new Comparator<Gift>() {
             @Override
             public int compare(final Gift gift1, final Gift gift2) {
              return (int) (-(gift1.price-(gift2.price)));
                }
            });
        }
        for(Boy b : boy) {
            
            if(b.status.equals("commited")) {
              Gift[] goof=new Gift[10];
             
              int i=0;
             
           
                float sum=b.giffy2(gift,file);
                b.girl.happiness=b.happiness(sum);
                b.girl.comp=compatibility(b,sum);
        } 
            
       }
     }
}
