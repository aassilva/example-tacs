package br.ufg.inf.es.tacs.servico;

import br.ufg.inf.es.tacs.dominio.Lance;
import br.ufg.inf.es.tacs.dominio.Leilao;

public class Avaliador {

    private double maiorTodos = Double.NEGATIVE_INFINITY;
    private double menorTodos = Double.POSITIVE_INFINITY;

    public void avaliar(Leilao leilao) {

        for (Lance lance : leilao.getLances()) {

            if (lance.getValor() > maiorTodos) {
                maiorTodos = lance.getValor();
            }
            if (lance.getValor() < menorTodos) {
                menorTodos = lance.getValor();
            }
        }
    }

    public double getMaiorTodos() {
        return maiorTodos;
    }

    public double getMenorTodos() {
        return menorTodos;
    }
}
