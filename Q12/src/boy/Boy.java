//boy class
package boy;

import commit.Pair;
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
 * boy class with setters and other functions also contains handler function triggered by Newgirl event
 */
public class Boy {
     public  String name;
     public int attract;
     public int budget;
    public int itg;
    public  int minattract;
    public String status;
    public Girl girl;
   public Boy(String name,int attract,int mbudget,int itg,int a) {
        this.name=name;
        this.attract=attract;
        this.budget=mbudget;
        this.itg=itg;
        this.minattract=a;
        status="Single";
        girl=null;
    } 
    public void change(String s1,Girl s2) {        //to change status and girl
        status=s1;
        girl=s2;
    }
    public int choose(Girl g) {            //to choose a girl
        if(g.attract>=minattract)
            return 1;
        else return 0;
    }
    public float happiness(float sum) {         //to find happiness
        return sum;
    }
    public float giffy(List<Gift> gift,String file) {     //for gifting
        return 0;
    }
    
    public void budgetalloc(int bud) {
        if(this.status.equals("Single"))
        budget=budget+bud;
        else
            budget=bud;
    }
     public void handler(Girl g) {
        int x=Pair.pair(g, this);
                    if(x==1) {
                     g.change("commited",this);
                     this.change("commited",g);
                        
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    try( BufferedWriter w=new BufferedWriter(new FileWriter("src\\commitlog.txt",true))) {
                         w.write(g.name+" got committed with "+ this.name+" on "+dtf.format(now));
            
                        w.newLine();
                    }
                    catch(IOException e) {
                     e.printStackTrace();
                    }
                    System.out.println(g.name+" got commited with "+this.name+" on "+dtf.format(now));
            
                    } 
                   
                 } 
                   
                   
           
          
}
