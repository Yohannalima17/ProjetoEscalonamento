package P2_SO;

public class Processo {
    private int ID;
    private int QuantidadeInstrucoes;

    public Processo(int ID, int QuantidadeInstrucoes) {
        this.ID = ID;
        this.QuantidadeInstrucoes = QuantidadeInstrucoes;
    }

    public int getID() {
        return ID;
    }

    public int getQuantidadeInstrucoes() {
        return QuantidadeInstrucoes;
    }

    public void decrementarInstrucoes() {
        QuantidadeInstrucoes--;
    }
}
