package javaSource.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por leitura do arquivo e extração das etapas.
 * Esta classe recebe o nome do arquivo e efetua sua leitura.
 */
public class Arquivo {

    private String nomeDoArquivo;

    /**
     * Construtor que recebe o nome do arquivo.
     *
     * @param nomeDoArquivo o nome do arquivo a ser lido
     */
    public Arquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    /**
     * Lê as etapas de montagem a partir do arquivo.
     *
     * @return a lista de etapas de montagem
     * @throws IOException se ocorrer um erro na leitura do arquivo
     */
    public List<EtapaMontagem> lerEtapasMontagem() throws IOException {
        List<EtapaMontagem> etapasMontagem = new ArrayList<>();

        try (FileReader reader = new FileReader(nomeDoArquivo);
             BufferedReader buffer = new BufferedReader(reader)) {

            String linha;
            while ((linha = buffer.readLine()) != null) {
                String[] partes = linha.split(" ");
                EtapaMontagem etapa = new EtapaMontagem(linha, extrairDuracao(partes[partes.length - 1]));
                etapasMontagem.add(etapa);
            }
        }

        return etapasMontagem;
    }

    private Long extrairDuracao(String duracao) {
        if (duracao.equals("maintenance")) {
            return 5L;
        }
        return Long.parseLong(duracao.replace("min", ""));
    }

    /**
     * Obtém o nome do arquivo.
     *
     * @return o nome do arquivo
     */
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }
}
