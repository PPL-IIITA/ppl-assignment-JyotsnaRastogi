
package boy;
import gift.Gift;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Exc.*;
/**
 * 
  class for geek boy
 */
public class Geek extends Boy{
    
   public Geek(String name,int attract,int mbudget,int itg,int a) {
        super(name,attract,mbudget,itg,a);
    } 
   /**
    * 
    * @param sum
    * @return 
    */
    public float happiness(float sum)  { /*function fo finding happiness of each couple*/
        
        float happiness;
        happiness=girl.itg+ girl.girlhappy(sum);
        return happiness;
    }
   @Override
    public float giffy(List<Gift> gift,String file) throws OutOfBudget  {     //class for gift allocation
         Girl g=girl;
         float sum=0;
            float s1=0,s2=0;
                float x=0;
                 for(Gift gif:gift) {
                    if((g.mbudget-x)>0) {
                        if(gif.price<=(g.mbudget-x)) {
                            x+=gif.price;
                             DateFormat d = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date date = new Date();
                            String str=gif.name+ " price " + gif.price+ " on "+date;
                             
                       try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                                 w.write(name+" gifted "+ girl.name+ "- ");
                                w.write(str);
                                w.newLine(); 
                             }
                             catch(IOException e) {
                                 e.printStackTrace();
                             }
                            sum+=gif.price;
                         
                           s1+=gif.price+2*gif.value;
                        
                            s2+=gif.price+gif.value;
                        }
                    }
                    else {
                        
                        throw new OutOfBudget(gif);
                       
                        
                    }
                }
                   if(girl.type.equals("choosy")) 
                    return s1;
                else if(girl.type.equals("normal")) 
                    return s2;
                else 
                    return sum;
    } 
}
               
             

