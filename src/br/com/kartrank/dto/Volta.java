/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kartrank.dto;

import java.sql.Time;

/**
 *
 * @author João
 */
public class Volta {

    private int numero;
    private Time hora;
    private String tempo;
    private Double velocidadeMedia;

    public Volta() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    
    
}
