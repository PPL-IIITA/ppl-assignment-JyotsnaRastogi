
package boy;

import gift.Gift;
import girl.Girl;
import java.util.List;
import Exc.*;

/**
 *
class for  boy and his attributes and setter function  is given here 
*/
 
 
public class Boy {
     public  String name;
     public int attract;
     public int budget;
    public int itg,done;
    public  int minattract;
    public String status;
    public Girl girl;
   public Boy(String name,int attract,int mbudget,int itg,int a) {     //Boy constructor
        this.name=name;
        this.attract=attract;
        this.budget=mbudget;
        this.itg=itg;
        this.minattract=a;
        status="Single";
        girl=null;
        done=0;
    } 
    public void change(String s1,Girl s2) {     //method to change status and girlfriend
        status=s1;
        girl=s2;
    }
    public int choose(Girl g) {                //method to choose appropriate boy
        if(g.attract>=minattract)
            return 1;
        else return 0;
    }
    public float happiness(float sum) {        //method to find happiness
        return sum;
    }
    public float giffy(List<Gift> gift,String file) throws OutOfBudget {       //method for gifting
        return 0;
    }
   
                 
    
}
