/* class for boy and his attributes and setter function  is given here */
package boy;
import girl.Girl;

public class Boy {
     public  String name;
     public int attract;
     public int budget;
    public int itg;
    public String type;
    int minattract;
    public String status;
    public Girl girl;
   public Boy(String name,int attract,int mbudget,int itg,String type,int a) {
        this.name=name;
        this.attract=attract;
        this.budget=mbudget;
        this.itg=itg;
        this.type=type;
        this.minattract=a;
        status="Single";
        girl=null;
    } 
    public void change(String s1,Girl s2) {
        status=s1;
        girl=s2;
    }
    public int choose(Girl g) {
        if(g.attract>=minattract)
            return 1;
        else return 0;
    }
}
