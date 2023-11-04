package P2_SO;

import java.util.ArrayList;
import java.util.List;

public class Escalonador {
    private List<Processo> processos = new ArrayList<>();
    private String algoritmo;
    private int quantum;
    private List<Processo> processos_prioritarios = new ArrayList<>();

    public Escalonador(String algoritmo, int quantum) {
        this.algoritmo = algoritmo;
        this.quantum = quantum;
    }

    public void adicionarProcesso(Processo processo) {
        processos.add(processo);
    }

    public void adicionarProcessoPrioritario(Processo processo) {
        processos_prioritarios.add(processo);
    }

    public Processo proximoProcesso() {
        if (algoritmo.equals("FCFS")) {
            if (!processos.isEmpty()) {
                return processos.remove(0);
            }
        } else if (algoritmo.equals("SJF")) {
            processos.sort((p1, p2) -> Integer.compare(p1.getQuantidadeInstrucoes(), p2.getQuantidadeInstrucoes()));
            if (!processos.isEmpty()) {
                return processos.remove(0);
            }
        } else if (algoritmo.equals("RoundRobin")) {
            if (!processos.isEmpty()) {
                Processo processo = processos.remove(0);
                if (processo.getQuantidadeInstrucoes() > quantum) {
                    processo.decrementarInstrucoes();
                    processos.add(processo);
                    return new Processo(processo.getID(), quantum);
                } else {
                    return processo;
                }
            }
        } else if (algoritmo.equals("Prioridade")) {
            if (!processos_prioritarios.isEmpty()) {
                return processos_prioritarios.remove(0);
            } else if (!processos.isEmpty()) {
                return processos.remove(0);
            }
        }
        return null;
    }
}
