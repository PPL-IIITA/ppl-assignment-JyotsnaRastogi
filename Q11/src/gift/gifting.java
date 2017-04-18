// class for gifting anf happiness functions
package gift;

import Exc.OutOfBudget;
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
import commit.Pair;
import girl.Choosy;
import girl.Desperate;
import girl.Normal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Exc.*;
/**
 * 
 * class containing functions of gift,happiness and breakup 
 */
public class gifting {
     public float compatibility(Boy b,float sum) { /*function for finding compatibility of each couple*/
       
        float comp=sum-b.girl.mbudget+abs(b.girl.attract-b.attract)+abs(b.girl.itg-b.itg);
        return comp;
    }
    public void gifther(List<Boy> boy,List<Gift> gift) throws IOException, OutOfBudget { /*function performing gifting to girls using greedy approach*/
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
             
             try {
                 float sum=b.giffy(gift,file);
                b.girl.happiness=b.happiness(sum);
                b.girl.comp=compatibility(b,sum);
            }
            catch(OutOfBudget e) {
                System.out.println("gift "+e.sendgift().name+" is out of budget");
                 e.printStackTrace();
            }
               
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
    
     public void breakup(List<Girl> girl,int k,List<Boy> boy)  throws BoyNotFound  { /*function to find k  least happiest and break up*/
        
       int i=0;
                 if (girl.size() > 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             
             
             public int compare(final Girl girl1, final Girl girl2) {
              return (int) (-(girl2.happiness-(girl1.happiness)));
                }
            });
        }
            
                System.out.println(k+" least happiest couples who breakup - ");
             for(Girl g : girl) {
                 if(g.happiness!=0) {
                     if(i>=k)
                         break;
                  
               
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try( BufferedWriter w=new BufferedWriter(new FileWriter("src\\commitlog.txt",true))) {
                         w.write(g.name+" broke up with "+ g.boy.name+" on "+dtf.format(now));
            
                        w.newLine();
                    }
                    catch(IOException e) {
                     e.printStackTrace();
                    }
                     System.out.println(g.name+" broke up with "+ g.boy.name+" on "+dtf.format(now));
                   i++;
                   g.status="Single";
                    Boy by=g.boy;
                   g.boy=null;
                    for (Boy b : boy) {
                    int x=Pair.pair(g, b);
                    if(x==1) {
                     g.change("commited",b);
                     b.change("commited",g);
                        
                 
                    try( BufferedWriter w=new BufferedWriter(new FileWriter("src\\commitlog.txt",true))) {
                         w.write(g.name+" got committed with "+ b.name+" on "+dtf.format(now));
            
                        w.newLine();
                    }
                    catch(IOException e) {
                     e.printStackTrace();
                    }
                    System.out.println(g.name+" got commited with "+b.name+" on "+dtf.format(now));
            
                    } 
                   
                 } 
                    by.status="Single";
                    by.girl=null;
                    if(g.status.equals("Single"))
                         
                         //System.out.println(g.name+" could not find someone based on her choice ");
                        throw new BoyNotFound(g);
             
           
          
                 }
     }
 }

     
    
}
