package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * ******************* students' imports here ********************************
 */
import Thairam.BrincandoComPilhaFilaLista;
import Thairam.PilhaComFilas;
import Thairam.Pilha_IF;

public class TestDiamondCount {

    Pilha_IF pilha = null;

    @Before
    public void instanciaPilha() { //instancia pilha com tamanho 1000
        pilha = new PilhaComFilas(1000);
    }

    @Test
    public void testaEntrada1() throws Exception {
        String entrada = "<<<..<......<<<<....>";
        BrincandoComPilhaFilaLista.qtdDiamantes(entrada);
        assertEquals(1, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada2() throws Exception {
        String entrada = "<..><.<..>>";
        assertEquals(3, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada3() throws Exception {
        String entrada = "<><><><>";
        assertEquals(4, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada4() throws Exception {
        String entrada = "<<<..><.<..>>>><>";
        assertEquals(6, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada5() throws Exception {
        String entrada = ".>><..<<<>.<.>>..>...<<.>....";
        assertEquals(5, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada6() throws Exception {
        String entrada = "";
        assertEquals(0, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada7() throws Exception {
        String entrada = "...>>>...<<<...";
        assertEquals(0, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada8() throws Exception {
        String entrada = ".<..<><..>><.>><.<.>.>..>><>.><.><.><<>><><<..>>.><>>.>>>>..."
                + "<>>><>.><<....>..><><<>><.>..><>.><.><<>>><>>.>><>><.<>..<>.<><<>.>>><..."
                + "<.>..<><<>>.>>>.<.>..<..<>><.<>..<<..<<<><<.><<><><<<<.<<.";
        assertEquals(48, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }

    @Test
    public void testaEntrada9() throws Exception {
        String entrada = ">.<.>.>.....<><<.>>.<..>>>><<<>>.>><>>..><.<><.<.<>><.<<<>.."
                + "<<>>>.>><><><><.>>><>.>>..<.<.>..>>.<<>><<>.<..<.><>.<<><.>>><><.><<>"
                + ".<<<>>.<.>..<<<<.<<>.><...>>><<>><.>.>.>.>>.<.<>><<<..><>>.>.<.<>.<>>>"
                + ".>>.<.<...><><>>><<>>.<<<...<<><>>.>..><>>><<..>>>.<.>>><><.<.<><<..<.."
                + "<..>.>..>>>>...<<><<<>...>..>>.<.>>>....<>>.><...>>.>..<<.<..<>>><.>>>>"
                + ">.<......><>><>>.><.>>><<<><.<.><><<..><.><><>.<><<>><><.>.><>.>.>.>>.."
                + "<...>><<>.<<.<..>><<<.>...<.>.>.>><><<>>>.><<<<>....<>>><><.<<.<<>.<<>>>"
                + ".><><>>>>.<>.<>>.><.>.><<<.>.>><>.>.>.<<><><.<><.>>.>.><..>>>..<>>.<><.<.>"
                + "...>><>..<<<>..>>><...<.<><.>><><.><<>>><<>.<><<<><..><..<<.<...><.";
        assertEquals(185, BrincandoComPilhaFilaLista.qtdDiamantes(entrada));
    }
}
