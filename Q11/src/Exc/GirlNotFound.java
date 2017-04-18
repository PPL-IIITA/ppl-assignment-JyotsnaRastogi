
package Exc;

import boy.Boy;

/**
 *
 * class defining girlfriend not found exception
 */
public class GirlNotFound extends Exception {
    Boy b;
    public GirlNotFound(Boy b) {
        this.b=b;
    }
    public Boy sendboy() {
        return b;
    }
}