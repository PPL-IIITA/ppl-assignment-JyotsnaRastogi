//utility guft class
package gift;


public class Utility extends Gift {
    public int utval,utclass;
    public Utility(String name,int price,int value,int utclass,int utval) {
        super(name,price,value);
        this.utval=utval;
        this.utclass=utclass;
    }
}
