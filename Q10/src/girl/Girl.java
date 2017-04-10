/*
class for girl
 */
package girl;

import boy.Boy;

public class Girl {
      public String name;
    public int attract;
    public int mbudget;
    public int itg,done;
    public String type;
    public int attneed;
    public int itgneed;
    public String status;
    public Boy boy;
    public float happiness,comp;
    public Girl(String name,int attract,int mbudget,int itg,String type,int a,int b) {   //constructor
        this.name=name;
        this.attract=attract;
        this.mbudget=mbudget;
        this.itg=itg;
        this.type=type;
        attneed=a;
        itgneed=b;
        this.status="Single";
        boy=null;
        this.happiness=0;
        this.comp=0;
        this.done=0;
    }
    public void change(String s1,Boy s2) { //method to change status and boyfriend
        status=s1;
        boy=s2;
    }
     public int choose(Boy b) {        //method for choosing boy
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
    public  float girlhappy(float s) {             //method to find out happiness of girl
        float h=s;
        return h;
    }
}
