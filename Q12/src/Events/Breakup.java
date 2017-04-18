
package Events;

import boy.Boy;
import gift.Gift;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 *Breakup event class handles breakup with Handle function
 */
public class Breakup implements MyListener {
    public void Handler(Girl g,List<Boy> boy,List<Gift> gift) {
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
                   
                   g.status="Single";
                    Boy by=g.boy;
                   g.boy=null;
                   Newgirl n=new Newgirl();
                   n.Handler(g, boy,gift);
                   
                     by.status="Single";
                    by.girl=null;
    }
}
