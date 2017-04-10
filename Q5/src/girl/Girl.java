/*class containing attributes and setter function or girl*/
 
package girl;
import boy.Boy;


public class Girl {

    public String name;
    public int attract;
    public int mbudget;
    public int itg;
    public String type;
    public int attneed,done;
    public int itgneed;
    public String status;
    public Boy boy;
    public float happiness,comp;
    public Girl(String name,int attract,int mbudget,int itg,String type,int a,int b) {     //constructor
        this.name=name;
        this.attract=attract;
        this.mbudget=mbudget;
        this.itg=itg;
        this.type=type;
        int i;
        attneed=a;
        itgneed=b;
        this.status="Single";
        boy=null;
        this.happiness=0;
        this.comp=0;
        this.done=0;
    }
    public void change(String s1,Boy s2) {       //to change status and boy
        status=s1;
        boy=s2;
    }
     public int choose(Boy b) {               //to choose  a boy
        int a=0;
        if(b.budget>=mbudget)
            a=1;
        if(a==1) {
            if(b.attract>=attneed&&b.itg>=itgneed)
                return 1;
            else return 0;
        }
        else 
            return 0;
    }
     
     public  float girlhappy(float s) { //to find girl's happiness
        float h=s;
        return h;
    }
    
}
