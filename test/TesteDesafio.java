/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import desafiozup.Platform;
import desafiozup.Position;
import desafiozup.Rover;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diegofs
 */
public class TesteDesafio {
    
    public TesteDesafio() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSpinRover() {
        Platform platform = new Platform(5,5);
        Position posicao = new Position(1,2,"N");
        Rover rover = new Rover(posicao, platform);
        
        assertEquals("W", rover.spinRover('L'));
    }
    
    @Test
    public void walkThroughPlatform1() {
        Platform platform = new Platform(5,5);
        Position posicao = new Position(1,2,"N");
        Rover rover = new Rover(posicao, platform);
        String commands = "LMLMLMLMM";
        char[] roverCommands = commands.toCharArray();
        
        Position resultadoRetornado = rover.walkThroughPlatform(roverCommands);
        Position resultadoEsperado = new Position(1,3,"N");
        
        assertTrue(resultadoEsperado.equals(resultadoEsperado));
        
    }
    
    @Test
    public void walkThroughPlatform2() {
        Platform platform = new Platform(5,5);
        Position posicao = new Position(3,3,"E");
        Rover rover = new Rover(posicao, platform);
        String commands = "MMRMMRMRRM";
        char[] roverCommands = commands.toCharArray();
        
        Position resultadoRetornado = rover.walkThroughPlatform(roverCommands);
        Position resultadoEsperado = new Position(5,1,"E");
        
        assertTrue(resultadoEsperado.equals(resultadoEsperado));
        
    }
}
