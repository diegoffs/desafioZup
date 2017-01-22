/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiozup;

import javax.swing.JOptionPane;

/**
 *
 * @author diegofs
 */
public class InputValidator {
    
    
    public boolean firstLineInputValidation (String[] plateauCoordinates) {
        boolean invalid = false;

        for(int i = 0; i < plateauCoordinates.length; i++) {
            if(Character.isLetter(plateauCoordinates[i].charAt(0)) || plateauCoordinates.length != 2) {
                invalid = true;
            }
        }
        if(invalid == true) {
            JOptionPane.showMessageDialog(null, "Entrada inválida, digite novamente" ,"Error", 0 );
        }
        return invalid;
        
    }
    
        public boolean secondLineInputValidation (String[] splittedNextRoverPosition) {
        boolean invalid = false;
        
        if(splittedNextRoverPosition.length != 3 
                || Character.isLetter(splittedNextRoverPosition[0].charAt(0)) 
                || Character.isLetter(splittedNextRoverPosition[1].charAt(0))
                || Character.isDigit(splittedNextRoverPosition[2].charAt(0))) {
            
            invalid = true;
        }
        
        if(invalid) {
            JOptionPane.showMessageDialog(null, "Posição do Rover inválida, digite novamente" ,"Error", 0 );
        }
        return invalid;
    }
        
        public boolean roverPositionOutsideOfPlatformValidation (String[] splittedNextRoverPosition, int maxPlatformX, int maxPlatformY) {
            int roverX = Integer.parseInt(splittedNextRoverPosition[0]);
            int roverY = Integer.parseInt(splittedNextRoverPosition[1]);
            boolean invalid = false;
            
            if(roverX > maxPlatformX || roverY > maxPlatformY) {
                invalid = true;
            }
            
            if(invalid) {
                JOptionPane.showMessageDialog(null, "Posição cadastrada excede o limite da plataforma, por favor digite novamente" ,"Error", 0 );
            }
            
            return invalid;
        }
        
                
        public boolean cardinalCompassPointsValidation (String cardinalCompassPoint) {
            boolean invalid = false;
            
            if(!cardinalCompassPoint.equals("N")  && !cardinalCompassPoint.equals("S")
               && !cardinalCompassPoint.equals("E") && !cardinalCompassPoint.equals("W")) {
                invalid = true;
            }
            
            if(invalid) {
                JOptionPane.showMessageDialog(null, "Posição: " + cardinalCompassPoint + " inválida, por favor digite novamente" ,"Error", 0 );
            }
            
            return invalid;
        }
        
        public boolean roverCommandsSequenceValidation (char[] roverCommands) {
            boolean invalid = false;
            int pos = 0;
            for(int i = 0; i < roverCommands.length; i++) {
                if(roverCommands[i] != 'L' && roverCommands[i] != 'R' && roverCommands[i] != 'M' ) {
                    invalid = true;
                     pos = i;
                     break;
                }
            }
            
            if(invalid) {
                JOptionPane.showMessageDialog(null, "Comando: " + roverCommands[pos] + " inválido, por favor digite novamente" ,"Error", 0 );
            }
            
            return invalid;
            
        }
        
        
}
