package P2_SO;

import java.util.Random;

public class CPU {
    private Escalonador escalonador;
    private int ciclosParaInterrupcao;
    private int ciclosRestantes;
    private Processo processoAtual;

    public CPU(Escalonador escalonador, int ciclosParaInterrupcao) {
        this.escalonador = escalonador;
        this.ciclosParaInterrupcao = ciclosParaInterrupcao;
        this.ciclosRestantes = ciclosParaInterrupcao;
        this.processoAtual = null;
    }

    public void executar() {
        while (true) {
            if (ciclosRestantes == 0 || processoAtual == null) {
                processoAtual = escalonador.proximoProcesso();
                if (processoAtual == null) {
                    break;
                }
                ciclosRestantes = ciclosParaInterrupcao;
            }

            processoAtual.decrementarInstrucoes();
            ciclosRestantes--;

            if (processoAtual.getQuantidadeInstrucoes() == 0) {
                System.out.println("Processo " + processoAtual.getID() + " finalizado.");
                processoAtual = null;
            }

            if (Math.random() < 0.1) {
                Processo novoProcesso = new GeradorDeProcessos().gerarProcesso();
                escalonador.adicionarProcesso(novoProcesso);
                System.out.println("Novo processo " + novoProcesso.getID() + " adicionado.");
            }
        }
    }
}