/*
functions performing gifting and break up
 */
package gift;

import Events.Breakup;
import Events.MyListener;
import boy.Boy;

import java.io.IOException;
import static java.lang.Math.abs;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;



/**
 * 
 * Class performing gifting and happiness functions and triggers breakup event 
 */
public class gifting {
     public float compatibility(Boy b,float sum) { /*function for finding compatibility of each couple*/
       
        float comp=sum-b.girl.mbudget+abs(b.girl.attract-b.attract)+abs(b.girl.itg-b.itg);
        return comp;
    }
    public void gifther(Boy b,List<Gift> gift,List<Boy> boy) throws IOException { /*function performing gifting to girls using greedy approach*/
            String file="src\\gifting.txt";
          
                 
          if(gift.size()> 0) {
             Collections.sort(gift, new Comparator<Gift>() {
             @Override
             public int compare(final Gift gift1, final Gift gift2) {
              return (int) (-(gift1.price-(gift2.price)));
                }
            });
        }
        
            
            if(b.status.equals("commited")) {
              Gift[] goof=new Gift[10];
             
              int i=0;
             
           
                float sum=b.giffy(gift,file);
                if(sum==-1) {
                    MyListener m=new Breakup();
                     m.Handler(b.girl,boy, gift);
                    
                    return;
                }
                b.girl.happiness=b.happiness(sum);
                b.girl.comp=compatibility(b,sum);
        } 
            
       
    } 

 }
     
     

           
            