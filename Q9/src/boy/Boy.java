//boy class
package boy;

import gift.Gift;
import girl.Girl;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Boy {
     public  String name;
     public int attract;
     public int budget;
    public int itg,done;
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
        this.done=0;
    } 
    public void change(String s1,Girl s2) {   //to change status anf girlfriend
        status=s1;
        girl=s2;
    }
    
    public float happiness(float sum) {    //to find happiness
        return sum;
    }
    public float giffy(List<Gift> gift,String file) {   //for gifting
      
        return 0;
    }
}
