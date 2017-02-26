/*class containing functions to implement algorithms*/

package gift;
import girl.Girl;
import boy.Boy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class gifting { 
    public float girlhappy(Girl g,float s,float s1,float s2) {
        float happiness=0; 
        if(g.type=="choosy") {
             happiness=(float) log(s1/g.mbudget);  
           }
        else if(g.type=="normal") 
            happiness=s2/g.mbudget;
            else 
            happiness=(float) exp(s/g.mbudget);
        return happiness;
    }
    public float happiness(Boy b,float sum,float s1,float s2)  { /*function fo finding happiness of each couple*/
        
        float happiness;
       
        if(b.type.equals("miser")) {
           happiness=(b.budget-sum)+girlhappy(b.girl,sum,s1,s2);
          
        } 
        else if(b.type.equals("generous")) {
           happiness=2*girlhappy(b.girl,sum,s1,s2);
          
        }  
         else {
           happiness=b.girl.itg+girlhappy(b.girl,sum,s1,s2);
          
        } 
        return happiness;
    }
    
    public float compatibility(Boy b,float sum) { /*function for finding compatibility of each couple*/
       
        float comp=sum-b.girl.mbudget+abs(b.girl.attract-b.attract)+abs(b.girl.itg-b.itg);
        return comp;
    }
    public void gifther(List<Boy> boy,List<Gift> gift) throws IOException { /*function performing gifting to girls using greedy approach*/
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
            float sum=0;
            float s1=0,s2=0;
            if(b.status.equals("commited")) {
              Gift[] goof=new Gift[10];
              String str; 
              int i=0;
             
              if(b.type.equals("miser")) {
                Girl g=b.girl;
                float x=0;
                for(Gift gif:gift) {
                    if((g.mbudget-x)>0) {
                        if(gif.price<=(g.mbudget-x)) {
                            x+=gif.price;
                            
                            DateFormat d = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date date = new Date();
                            str=gif.name+ " price " + gif.price+ " on "+date;
                             try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                                 w.write(b.name+" gifted "+ b.girl.name+ "- ");
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
                    else
                        break;
                     
                }
               
            }
            else if(b.type.equals("generous")) {
               
               
                float x=0;
                for(Gift gif:gift) {
                    if((b.budget-x)>0) {
                        if(gif.price<=(b.budget-x)) {
                            x+=gif.price;
                           DateFormat d = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date date = new Date();
                            str=gif.name+ " price " + gif.price+ " on "+date;
                              
                                sum+=gif.price;
                         
                           s1+=gif.price+2*gif.value;
                        
                            s2+=gif.price+gif.value;
                              try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                                 w.write(b.name+" gifted "+ b.girl.name+ "- ");
                                w.write(str);
                                w.newLine(); 
                             }
                             catch(IOException e) {
                                 e.printStackTrace();
                             }
                        }
                    }
                    else
                        break;
                }
               
            } 
             else  {
               
               
              Girl g=b.girl;
                float x=0;
                for(Gift gif:gift) {
                    if((g.mbudget-x)>0) {
                        if(gif.price<=(g.mbudget-x)) {
                            x+=gif.price;
                             DateFormat d = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date date = new Date();
                            str=gif.name+ " price " + gif.price+ " on "+date;
                             
                       try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                                 w.write(b.name+" gifted "+ b.girl.name+ "- ");
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
                    else
                        break;
                }
               
            } 
            
            
            
                b.girl.happiness=happiness(b,sum,s1,s2);
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

