/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiozup;

/**
 *
 * @author diegofs
 */
public class Platform {
    private int xMaxPlatform;
    private int yMaxPlatform;

    public Platform(int xMaxPlatform, int yMaxPlatform) {
        this.xMaxPlatform = xMaxPlatform;
        this.yMaxPlatform = yMaxPlatform;
    }

    public int getxMaxPlatform() {
        return xMaxPlatform;
    }

    public void setxMaxPlatform(int xMaxPlatform) {
        this.xMaxPlatform = xMaxPlatform;
    }

    public int getyMaxPlatform() {
        return yMaxPlatform;
    }

    public void setyMaxPlatform(int yMaxPlatform) {
        this.yMaxPlatform = yMaxPlatform;
    }
    
}
