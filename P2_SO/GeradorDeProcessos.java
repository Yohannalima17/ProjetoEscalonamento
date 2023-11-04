package P2_SO;

import java.util.Random;

public class GeradorDeProcessos {
    private int ID_counter = 0;
    private Random random = new Random();

    public Processo gerarProcesso() {
        ID_counter++;
        int QuantidadeInstrucoes = random.nextInt(41) + 10; // Entre 10 e 50
        return new Processo(ID_counter, QuantidadeInstrucoes);
    }
}
