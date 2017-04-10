/*file containing the main function*/ 
package main;
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
import java.util.Random;


/**
 * 
 * file containing the main function
 */
public class Main {
   
    public static void main(String[] args) throws IOException   {      //main function
            Random r=new Random();
            int i=0;
           test2 t=new test2();
            t.tester();
              List<Boy> boy=file.readb("src\\boy.csv");
            List<Girl> girl=file.readg("src\\girl.csv");
            List<Gift> gift=file.readgift("src\\gift.csv");
            String file="src\\commitlog.txt";
            gifting gif=new gifting();
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
            int tt=1+r.nextInt(10);
            for(i=1;i<=tt;i++) {
                int ttt=1+r.nextInt(31);
                    System.out.println("after "+ttt+" day couples that break up are ");
                    
                  gif.gifther(boy, gift);
                  gif.breakup(girl, ttt, boy);
            }
          
         
            
        } 
}
    
