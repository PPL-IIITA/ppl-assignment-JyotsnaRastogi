/*file containing the main function*/ 
package main;
import utility.test2;
import boy.Boy;

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
import java.util.Random;
import General.*;


public class Main {
   
    public static void main(String[] args) throws IOException   {
            Random r=new Random();
            int i=0;
           test2 t=new test2();
            t.tester();
              List<Boy> boy=file.readb("src\\boy.csv");
            List<Girl> girl=file.readg("src\\girl.csv");
            List<Gift> gift=file.readgift("src\\gift.csv");
            String file="src\\commitlog.txt";
            gifting gif=new gifting();
            Sort s=new Sort();
            s.bsort(boy);
            s.gsort(girl);
            s.gifsort(gift);
            int k=2+r.nextInt(12);
            Template<Boy> boytemp=new Template<Boy>();           //use of generic class named Template
            Template<Girl> girltemp=new Template<Girl>();
            Template<Gift> gifttemp=new Template<Gift>();
            List<Boy> bk=boytemp.ksort(boy, k);
            List<Girl> gk=girltemp.ksort(girl,k);
            List<Gift> gifk=gifttemp.ksort(gift,k);
            int n=girl.size();
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
                        b2=s.choose(bk, gl);
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
                    { 
                        by.done=1;
                      g2 = s.choose(gk, by);
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
            int z=1+r.nextInt(c);
            gif.gifther(boy, gifk);
            gif.sort(girl,z);
            
        } 
}
    
