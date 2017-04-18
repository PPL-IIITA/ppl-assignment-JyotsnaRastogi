/*file containing the main function*/ 
package main;
import Exc.BoyNotFound;
import Exc.GirlNotFound;
import Exc.OutOfBudget;
import utility.test2;
import boy.Boy;
import commit.Pair;
import gift.Gift;
import gift.gifting;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import readfile.file; 
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


/**
 * 
 * Class containing main function
 */
public class Main {
   
    public static void main(String[] args) throws IOException, OutOfBudget, GirlNotFound, BoyNotFound   {
            Random r=new Random();
            int i=0;
            int choice=r.nextInt(1);
           test2 t=new test2();
            t.tester();
              List<Boy> boy=file.readb("src\\boy.csv");
            List<Girl> girl=file.readg("src\\girl.csv");
            List<Gift> gift=file.readgift("src\\gift.csv");
            String file="src\\commitlog.txt";
            gifting gif=new gifting();
            try {
            if(choice==0) {
                
            for(Girl g : girl) {
                 i=0;
                for (Boy b : boy) {
                    int x=Pair.pair(g, b);
                    if(x==1) {
                     g.change("commited",b);
                    b.change("commited",g);
                        i++;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                         w.write(g.name+" got committed with "+ b.name+" on "+dtf.format(now));
            
                        w.newLine();
                    }
                    catch(IOException e) {
                     e.printStackTrace();
                    }
                    System.out.println(g.name+" got commited with "+b.name+" on "+dtf.format(now));
            
                    }
                }
            } 
                
            }
            
            else {
                    if (girl.size() > 0) {
             Collections.sort(girl, new Comparator<Girl>() {
             
             
                 public int compare(final Girl girl1, final Girl girl2) {
                        return (int) (-(girl1.mbudget-(girl2.mbudget)));
                 }
              });
            }
                    if (boy.size() > 0) {
             Collections.sort(boy, new Comparator<Boy>() {
             
             
                public int compare(final Boy boy1, final Boy boy2) {
                        return (int) (-(boy2.attract-(boy1.attract)));
                    }
                 });
            }
            
            int n = girl.size();
            System.out.println(n);
             i=0;
             int c=0;
               Girl gl = null,g2 = null;
                   Boy by=null,b2 = null;
            while(i!=n) {
                gl=null;
                g2=null;
                by=null;
                b2=null;
                  
                if(i%2==0) {
                   
                    for(Girl g : girl) {
                        if(g.status.equals("Single")&&g.done==0) {
                            gl=g;
                            
                            break;
                        }
                    }
                    if(gl!=null)
                    {
                        gl.done=1;
                    
                    b2 = Pair.pairgirl(gl, boy);
                    }
                    if(b2!=null)
                    b2.done=1;
                  
                }
                else { 
                    for(Boy b: boy) {
                         if(b.status.equals("Single")&&b.done==0) {
                            by=b;
                            break;
                        }
                    }
                    if(by!=null) 
                    {   by.done=1;
                      g2 = Pair.pairboy(girl, by);
                    }
                     if(g2!=null)
                      g2.done=1;
                     
                }
                if(by==null) {
                    if(b2==null) {
                        i++;
                        continue;
                    }
                    by=b2;
                }
                else if(gl==null) {
                    if(g2==null) {
                        i++;
                        continue;
                    }
                    gl=g2;
                }
                 gl.change("commited",by);
                 by.change("commited",gl); 
                 c++;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try( BufferedWriter w=new BufferedWriter(new FileWriter(file,true))) {
                         w.write(gl.name+" got committed with "+ by.name+" on "+dtf.format(now));
            
                        w.newLine();
                    }
                    catch(IOException e) {
                     e.printStackTrace();
                    }
                    System.out.println(gl.name+" got commited with "+by.name+" on "+dtf.format(now));
            
                     i++;                    
                }
               
                
            }
            }
            catch(BoyNotFound e) {
               
                System.out.println("girl "+e.sendgirl().name+" did not find a boy");
                e.printStackTrace();
            }
            catch(GirlNotFound e) {
                System.out.println("boy "+e.sendboy().name+" did not find a girl");
                 e.printStackTrace();
            }
           
            int k=1+r.nextInt(i+1);
           
                gif.gifther(boy, gift);
                gif.sort(girl,k);
                gif.breakup(girl, k, boy);
         
        } 
}
    
