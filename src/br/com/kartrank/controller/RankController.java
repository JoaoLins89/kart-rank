/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kartrank.controller;

import br.com.kartrank.constant.Constant;
import br.com.kartrank.dto.Piloto;
import br.com.kartrank.dto.Volta;
import br.com.kartrank.util.Util;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author João
 */
public class RankController {

    private List<Piloto> pilotos = null;

    public List<Piloto> lerArquivo(File file) {

        int posicao = 1;
        boolean linhaInicial = true;
        boolean outraVolta;
        String linhaAtual = "";

        try {

            Scanner in = new Scanner(new FileReader(file));
            while (linhaAtual != null) {
                outraVolta = false;
                if (linhaInicial) {
                    in.nextLine();
                    linhaAtual = in.nextLine();
                    linhaInicial = false;
                    pilotos = new ArrayList<Piloto>();
                } else {
                    if (!pilotos.isEmpty()) {
                        for (Piloto piloto : pilotos) {
                            if (piloto.getCodigo().equals(linhaAtual.substring(18, 21))) {

                                Volta volta = this.stringInVolta(linhaAtual);
                                piloto.getVoltas().add(volta);
                                piloto.setTempoTotalProva(Util.sumTime(piloto.getTempoTotalProva().replace('.', ':'), volta.getTempo().replace('.', ':')));
                                outraVolta = true;
                                break;
                            }
                        }
                        if (!outraVolta) {
                            pilotos.add(this.stringInPiloto(linhaAtual));
                        }
                    } else {
                        pilotos.add(this.stringInPiloto(linhaAtual));
                    }

                    linhaAtual = in.hasNextLine() ? in.nextLine() : null;
                }
            }
            Collections.sort(pilotos);

            for (Piloto piloto : pilotos) {
                piloto.setPosicao(posicao);
                posicao++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pilotos;

    }

    public String melhorTempo() {

        if (pilotos != null && !pilotos.isEmpty()) {

            return pilotos.get(0).getTempoTotalProva();
        } else {
            return "0:0.000";
        }
    }

    private Piloto stringInPiloto(String linha) throws Exception {

        Piloto retorno = new Piloto();
        retorno.setVoltas(new ArrayList<Volta>());

        Volta volta = this.stringInVolta(linha);

        retorno.setCodigo(linha.substring(18, 21));
        retorno.setNome(linha.substring(24, 38));
        retorno.setTempoTotalProva(volta.getTempo());
        retorno.getVoltas().add(volta);
        return retorno;
    }

    private Volta stringInVolta(String linha) throws ParseException {

        Volta retorno = new Volta();

        retorno.setHora(Util.converterStringTime(linha.substring(0, 12), Constant.FORMAT_HH_MM_SS_SSS));
        retorno.setNumero(Integer.parseInt(linha.substring(44, 45)));
        retorno.setTempo(linha.substring(50, 58));
        retorno.setVelocidadeMedia(Double.parseDouble(linha.substring(70, linha.length()).replace(',', '.')));

        return retorno;
    }

}
