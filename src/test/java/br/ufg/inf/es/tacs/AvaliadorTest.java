package br.ufg.inf.es.tacs;

import br.ufg.inf.es.tacs.dominio.Lance;
import br.ufg.inf.es.tacs.dominio.Leilao;
import br.ufg.inf.es.tacs.dominio.Usuario;
import br.ufg.inf.es.tacs.servico.Avaliador;
import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {

    @Test
    public void testCasoTrivial() {

        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 250.00));
        leilao.propoe(new Lance(jose, 300.00));
        leilao.propoe(new Lance(maria, 400.00));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avaliar(leilao);

        Assert.assertEquals(400.00, leiloeiro.getMaiorTodos(), 0.00001);
        Assert.assertEquals(250.00, leiloeiro.getMenorTodos(), 0.00001);


        leilao.propoe(new Lance(joao, 590.00));
        leilao.propoe(new Lance(jose, 500.00));
        leilao.propoe(new Lance(maria, 40.00));

        leiloeiro.avaliar(leilao);

        Assert.assertEquals(590.00, leiloeiro.getMaiorTodos(), 0.00001);
        Assert.assertEquals(40.00, leiloeiro.getMenorTodos(), 0.00001);


        leilao.propoe(new Lance(joao, 590.00));
        leilao.propoe(new Lance(jose, Double.NEGATIVE_INFINITY));
        leilao.propoe(new Lance(maria, Double.POSITIVE_INFINITY));

        leiloeiro.avaliar(leilao);

        Assert.assertEquals(Double.POSITIVE_INFINITY, leiloeiro.getMaiorTodos(), 0.00001);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, leiloeiro.getMenorTodos(), 0.00001);

    }
}
