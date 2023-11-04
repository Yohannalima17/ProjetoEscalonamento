package P2_SO;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GeradorDeProcessos gerador = new GeradorDeProcessos();
        Escalonador escalonador = new Escalonador("FCFS", 3);
        CPU cpu = new CPU(escalonador, new Random().nextInt(5) + 1);
        for (int i = 0; i < 5; i++) {
            Processo processo = gerador.gerarProcesso();
            escalonador.adicionarProcesso(processo);
        }
        cpu.executar();
    }
}