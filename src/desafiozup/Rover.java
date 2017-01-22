/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiozup;

import java.util.ArrayList;

/**
 *
 * @author diegofs
 */
public class Rover {
    
    private Position posicao;
    private Platform platform;
    private ArrayList<String> CardinalComapssPoints;

    public Rover(Position posicao, Platform platform) {
        this.posicao = posicao;
        this.platform = platform;
        CardinalComapssPoints = new ArrayList<>();
        CardinalComapssPoints.add("N");
        CardinalComapssPoints.add("E");
        CardinalComapssPoints.add("S");
        CardinalComapssPoints.add("W");
        
    }

    public Position getPosicao() {
        return posicao;
    }

    public void setPosicao(Position posicao) {
        this.posicao = posicao;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    
    public Position walkThroughPlatform (char[] roverCommands) {
        for(int i = 0; i < roverCommands.length; i++) {
            if(roverCommands[i] != 'M') {
                this.posicao.setLocation(this.spinRover(roverCommands[i]));
            } else {
                this.moveRover(roverCommands[i]);
            }
        }
        
        return this.posicao;
    }
    
    public String spinRover (char spinCommand) {
        if(spinCommand == 'R') {
            int i = 0;
            while((i < this.CardinalComapssPoints.size()) && (!this.posicao.getLocation().equals(this.CardinalComapssPoints.get(i))) ) {
                i++;
            }
            if(i == 3) {
                //this.posicao.setLocation(this.CardinalComapssPoints.get(0));
                return this.CardinalComapssPoints.get(0);
            } else {
                //this.posicao.setLocation(this.CardinalComapssPoints.get(i + 1));
                return this.CardinalComapssPoints.get(i + 1);
            }
        } else {
            int i = 0;
            while((i < this.CardinalComapssPoints.size()) && (!this.posicao.getLocation().equals(this.CardinalComapssPoints.get(i))) ) {
                i++;
            }
            if(i == 0){
                //this.posicao.setLocation(this.CardinalComapssPoints.get(3));
                return this.CardinalComapssPoints.get(3);
            } else {
                //this.posicao.setLocation(this.CardinalComapssPoints.get(i - 1));
                return this.CardinalComapssPoints.get(i - 1);
            }
        }
    }
    
    public void moveRover (char spinCommand) {
        if(this.posicao.getLocation().equals("N")) {
            int newPositionY = this.posicao.getY();
            newPositionY++;
            if(newPositionY > this.platform.getyMaxPlatform()) {
                newPositionY--;
            }
            this.posicao.setY(newPositionY);
            
        } else if(this.posicao.getLocation().equals("S")) {
            int newPositionY = this.posicao.getY();
            newPositionY--;
            if(newPositionY < 0) {
                newPositionY++;
            }
            this.posicao.setY(newPositionY);
            
        } else if(this.posicao.getLocation().equals("E")) {
            int newPositionX = this.posicao.getX();
            newPositionX++;
            if(newPositionX > this.platform.getxMaxPlatform()) {
                newPositionX--;
            }
            this.posicao.setX(newPositionX);
            
        } else {
            int newPositionX = this.posicao.getX();
            newPositionX--;
            if(newPositionX < 0) {
                newPositionX++;
            }
            this.posicao.setX(newPositionX);
        }
    }
}
