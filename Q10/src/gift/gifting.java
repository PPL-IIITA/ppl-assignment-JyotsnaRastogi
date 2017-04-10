/*class performing gifting and finding happiness and compatibility*/
package gift;

import boy.Boy;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import boy.Miser;
import boy.Generous;
import boy.Geek;
import girl.Choosy;
import girl.Desperate;
import girl.Normal;



public class gifting {
     public float compatibility(Boy b,float sum) { /*function for finding compatibility of each couple*/
       
        float comp=sum-b.girl.mbudget+abs(b.girl.attract-b.attract)+abs(b.girl.itg-b.itg);
        return comp;
    }
    public void gifther(List<Boy> boy,List<Gift> gift) throws IOException { /*function performing gifting to girls using greedy approach*/
            String file="src\\gifting.txt";
          
        for(Boy b : boy) {
            
            if(b.status.equals("commited")) {
             
              int i=0;
             
              
                float sum=b.giffy(gift,file);
                b.girl.happiness=b.happiness(sum);
                b.girl.comp=compatibility(b,sum);
        } 
            
       }
    } 
    
    public void sort(List<Girl> girl,int k)  { /*function to find k  most happiest and k most compatible couples*/
        
             if (girl.size() > 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             
             
             public int compare(final Girl girl1, final Girl girl2) {
              return (int) (-(girl1.happiness-(girl2.happiness)));
                }
            });
        }
             
                int i=0;
                System.out.println(k+" most happiest couples- ");
             for(Girl g : girl) {
                 if(g.happiness!=0) {
                     if(i>=k)
                         break;
                  
                 System.out.println(g.name+" and "+ g.boy.name);
                   i++;
                 }
             }
             
               if (girl.size() > 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             
             
             public int compare(final Girl girl1, final Girl girl2) {
              return (int) (-(girl1.comp-(girl2.comp)));
                }
            });
        }
             i=0;
             System.out.println(k+" most compatible couples- ");

                for(Girl g : girl) {
                 if(g.comp!=0) {
                     if(i>=k)
                         break;
                 System.out.println(g.name+" and "+ g.boy.name);
                   i++;
                 }
             }
          
             
     }
}
