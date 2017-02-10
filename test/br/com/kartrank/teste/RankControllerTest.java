package br.com.kartrank.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.kartrank.controller.RankController;
import br.com.kartrank.dto.Piloto;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João
 */
public class RankControllerTest {

    RankController controller;

    public RankControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        controller = new RankController();
    }

    @Test
    public void lerArquivoPrimeiroColocadoTest() {

        for (Piloto piloto : controller.lerArquivo(new File("C:/ws/kart-rank.txt"))) {
            assertEquals("038", piloto.getCodigo());
            break;
        }
    }

    @Test
    public void lerArquivoQtdPilotosTest() {

        assertEquals(6, controller.lerArquivo(new File("C:/ws/kart-rank.txt")).size());
    }

    @Test
    public void melhorTempoNotNullTest() {

        assertNotNull("4:11.578", controller.melhorTempo());
    }

    @Test
    public void melhorTempoTest() {

        controller.lerArquivo(new File("C:/ws/kart-rank.txt"));
        assertEquals("4:11.578", controller.melhorTempo());
    }

    @After
    public void tearDown() {
    }

}
