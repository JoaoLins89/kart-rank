package br.com.kartrank.dto;

import br.com.kartrank.util.Util;
import java.util.List;

/**
 *
 * @author João
 */
public class Piloto implements Comparable<Piloto> {

    private String codigo;
    private String nome;
    private String tempoTotalProva;
    private int posicao;
    private List<Volta> voltas;

    public Piloto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTempoTotalProva() {
        return tempoTotalProva;
    }

    public void setTempoTotalProva(String tempoTotalProva) {
        this.tempoTotalProva = tempoTotalProva;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public List<Volta> getVoltas() {
        return voltas;
    }

    public void setVoltas(List<Volta> voltas) {
        this.voltas = voltas;
    }

    @Override
    public int compareTo(Piloto o) {
        if ((this.getVoltas().size() >= o.getVoltas().size())
                && (Util.stringTimeInMillSeconds(this.getTempoTotalProva().replace('.', ':')) < Util.stringTimeInMillSeconds(o.getTempoTotalProva().replace('.', ':')))) {
            return -1;
        }else if ((this.getVoltas().size() <= o.getVoltas().size())
                && (Util.stringTimeInMillSeconds(this.getTempoTotalProva().replace('.', ':')) > Util.stringTimeInMillSeconds(o.getTempoTotalProva().replace('.', ':')))) {
            return 1;
        }

        return 0;
    }

}
