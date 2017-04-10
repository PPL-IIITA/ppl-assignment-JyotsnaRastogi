//utility gift class
package gift;

public class Utility extends Gift {
    public int utval,utclass;
    public Utility(String name,int price,int value,int utclass,int utval,String type) {
        super(name,price,value,type);
        this.utval=utval;
        this.utclass=utclass;
    }
}
