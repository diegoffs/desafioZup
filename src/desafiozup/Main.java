/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiozup;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author diegofs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        String firstLine = JOptionPane.showInputDialog(null, "Digite as extensões X e Y máximas da plataforma separadas por espaço (Exemplo:2 3 )", "Extensões" , -1);
        
        if(firstLine == null) {
            System.exit(0);
        }
        firstLine = firstLine.replaceAll("\\s+", " ");
        firstLine = firstLine.trim();
        String[] plateauCoordinates = firstLine.split(" ");
        
        InputValidator validator = new InputValidator();
        while(validator.firstLineInputValidation(plateauCoordinates)) {
            firstLine = JOptionPane.showInputDialog(null, "Digite as extensões X e Y máximas da plataforma separadas por espaço (Exemplo:2 3 )", "Extensões" , -1);
                if(firstLine == null) {
                System.exit(0);
            }
            firstLine = firstLine.replaceAll("\\s+", " ");
            firstLine = firstLine.trim();
            plateauCoordinates = firstLine.split(" ");
        }
        
        Platform platform = new Platform(Integer.parseInt(plateauCoordinates[0]), 
        Integer.parseInt(plateauCoordinates[1]));
        
        Object[] options = { "Enviar", "Cancelar"};
        int retorno = 0;
        
        while (retorno == 0) {

            String nextRoverPosition = JOptionPane.showInputDialog(null, "Digite a posição atual e o sentido inicial separados por espaço (Exemplo:1 4 E )", "Posição do Rover" , -1);
            if(nextRoverPosition == null){
                System.exit(0);
            }
            nextRoverPosition = nextRoverPosition.replaceAll("\\s+", " ");
            nextRoverPosition = nextRoverPosition.trim();
            nextRoverPosition = nextRoverPosition.toUpperCase();
            String[] splittedNextRoverPosition = nextRoverPosition.split(" ");
            
            while(validator.secondLineInputValidation(splittedNextRoverPosition) 
                    || validator.roverPositionOutsideOfPlatformValidation(splittedNextRoverPosition, 
                            platform.getxMaxPlatform(),platform.getyMaxPlatform())
                    || validator.cardinalCompassPointsValidation(splittedNextRoverPosition[2])) {
                
                nextRoverPosition = JOptionPane.showInputDialog(null, "Digite a posição atual e o sentido inicial separados por espaço (Exemplo:1 4 E )", "Posição do Rover" , -1);
                if(nextRoverPosition == null){
                    System.exit(0);
                }
                nextRoverPosition = nextRoverPosition.replaceAll("\\s+", " ");
                nextRoverPosition = nextRoverPosition.trim();
                nextRoverPosition = nextRoverPosition.toUpperCase();
                splittedNextRoverPosition = nextRoverPosition.split(" ");
            
            }

            Position posicao = new Position(Integer.parseInt(splittedNextRoverPosition[0]), 
            Integer.parseInt(splittedNextRoverPosition[1]), splittedNextRoverPosition[2]);

            Rover rover = new Rover(posicao, platform);

            String nextRoverCommands = JOptionPane.showInputDialog(null, "Digite a sequência de instruções para o Rover na Plataforma em Marte", "Sequênca de comandos" , -1);
            if(nextRoverCommands == null) {
                System.exit(0);
            }
            nextRoverCommands = nextRoverCommands.replaceAll("\\s+", " ");
            nextRoverCommands = nextRoverCommands.trim();
            nextRoverCommands = nextRoverCommands.toUpperCase();
            char[] roverCommands = nextRoverCommands.toCharArray();
            
            while(validator.roverCommandsSequenceValidation(roverCommands)) {
                nextRoverCommands = JOptionPane.showInputDialog(null, "Digite a sequência de instruções para o Rover na Plataforma em Marte", "Sequênca de comandos" , -1);
                if(nextRoverCommands == null) {
                    System.exit(0);
                }
                nextRoverCommands = nextRoverCommands.replaceAll("\\s+", " ");
                nextRoverPosition = nextRoverPosition.trim();
                nextRoverCommands = nextRoverCommands.toUpperCase();
                roverCommands = nextRoverCommands.toCharArray();
            }

            Position resultado = rover.walkThroughPlatform(roverCommands);

            JOptionPane.showMessageDialog(null, resultado.getX() + " " + resultado.getY() + " " + resultado.getLocation(), "Posição Final", -1 );

            retorno = JOptionPane.showOptionDialog(null, "Deseja enviar outro Rover", "Enviar Novo Rover?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        }
        
    }
    
}
