//generous boy class
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



    public class Generous extends Boy{
    
   public Generous(String name,int attract,int mbudget,int itg,int a) {
        super(name,attract,mbudget,itg,a);
    } 
     public float happiness(float sum)  { /*function for finding happiness of each couple*/
        
        float happiness;
        Girl g=girl;
         happiness=2*g.girlhappy(sum);
        return happiness;
    }
      public void gifthelp(Gift gif,String file) {
         DateFormat d = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date date = new Date();
                             String str=gif.name+ " price " + gif.price+" type "+gif.type+" on "+date;
                             
                       try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                                 w.write(name+" gifted "+ girl.name+ "- ");
                                w.write(str);
                                w.newLine(); 
                             }
                             catch(IOException e) {
                                 e.printStackTrace();
                             }
                          
    }
      public float giffy(List<Gift> gift,String file) {       //for 1 type of gifting 
         Girl g=girl;
         float sum=0;
         float s1=0,s2=0;
          float x=0;
      for(Gift gif:gift) {
                    if((budget-x)>0) {
                        if(gif.price<=(budget-x)) {
                            x+=gif.price;
                         
                              gifthelp(gif,file);
                                sum+=gif.price;
                         
                           s1+=gif.price+2*gif.value;
                        
                            s2+=gif.price+gif.value;
                          
                        }
                    }
                    else
                        break;
                }
                   if(girl.type.equals("choosy")) 
                    return s1;
                else if(girl.type.equals("normal")) 
                    return s2;
                else 
                    return sum;
               
            }
      
          public float giffy2(List<Gift> gift,String file) {    //second type of
         Girl g=girl;
         float sum=0;
         float s1=0,s2=0;
          float x=0;
            int e=0,l=0,u=0;
      for(Gift gif:gift) {
                    if((budget-x)>0) {
                        if(gif.price<=(budget-x)) {
                            x+=gif.price;
                          if(gif.type.equals("essential"))
                                e++;
                            else if(gif.type.equals("luxury"))
                                l++;
                            else
                                u++;
                              gifthelp(gif,file);
                                sum+=gif.price;
                         
                            s1+=gif.price+2*gif.value;
                        
                            s2+=gif.price+gif.value;
                          
                        }
                    }
                    else {
                         if(u==0) {
                            if(gif.type.equals("utility")) {
                                u++;
                                   gifthelp(gif,file);
                                      sum+=gif.price;
                         
                               s1+=gif.price+2*gif.value;
                        
                               s2+=gif.price+gif.value;
                            }
                        }
                        if(l==0) {
                             if(gif.type.equals("luxury")) {
                                l++;
                                gifthelp(gif,file);
                              sum+=gif.price;
                         
                              s1+=gif.price+2*gif.value;
                        
                               s2+=gif.price+gif.value;
                        
                            }
                        }
                        if(e==0) {
                              if(gif.type.equals("essential")) {
                                e++;
                                gifthelp(gif,file);
                              sum+=gif.price;
                         
                              s1+=gif.price+2*gif.value;
                        
                               s2+=gif.price+gif.value;
                        
                            }
                        }
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

