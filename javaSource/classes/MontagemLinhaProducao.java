package javaSource.classes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe responsável por executar a montagem da linha de produção.
 * Esta classe recebe um horário de trabalho e um arquivo contendo as etapas de montagem,
 * e realiza a organização das etapas dentro do horário de trabalho estabelecido.
 */
public class MontagemLinhaProducao {

    private static final String TITULO_LINHA_MONTAGEM = "Linha de Montagem: ";
    private final HorariosTrabalho horario;
    private final Arquivo arquivo;

    public MontagemLinhaProducao(HorariosTrabalho horario, Arquivo arquivo) {
        this.horario = horario;
        this.arquivo = arquivo;
    }

    /**
     * Executa a montagem da linha de produção.
     */
    public void executar() {
        try {
            List<EtapaMontagem> etapasMontagem = arquivo.lerEtapasMontagem();
            String linhasMontagem = montarLinhasProducao(etapasMontagem, 1, horario.getDataHoraInicioTrabalho());
            System.out.println(linhasMontagem);
        } catch (IOException ioe) {
            System.out.println("Erro ao ler o arquivo " + arquivo.getNomeDoArquivo() + ": " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao executar a montagem da linha de produção: " + e.getMessage());
        }
    }

    private Boolean isPeriodoManhaValido(LocalDateTime dataHoraAtual, Long minutosAdicionar) {
        if (dataHoraAtual.isBefore(horario.getAlmoco())) {
            LocalDateTime novaHora = dataHoraAtual.plusMinutes(minutosAdicionar);
            if (novaHora.isAfter(horario.getAlmoco())) {
                dataHoraAtual.minusMinutes(minutosAdicionar);
                return Boolean.FALSE;
            }
        }
        return !dataHoraAtual.isEqual(horario.getAlmoco()) && !dataHoraAtual.isAfter(horario.getAlmoco());
    }

    private Boolean isDuracaoLaboralMinimaValida(LocalDateTime dataHoraAtual, Long minutosAdicionar) {
        if (dataHoraAtual.isEqual(horario.getDataHoraMinLaboral()) && minutosAdicionar <= 60L) {
            return Boolean.TRUE;
        }
        if (dataHoraAtual.isEqual(horario.getDataHoraMinLaboral()) && minutosAdicionar > 60L) {
            return Boolean.FALSE;
        }
        return isDuracaoLaboralMaximaValida(dataHoraAtual, minutosAdicionar);
    }

    private Boolean isDuracaoLaboralMaximaValida(LocalDateTime dataHoraAtual, Long minutosAdicionar) {
        if (dataHoraAtual.isEqual(horario.getDataHoraMaxLaboral())) {
            return Boolean.FALSE;
        }
        if (dataHoraAtual.isBefore(horario.getDataHoraMaxLaboral())) {
            LocalDateTime novaHora = dataHoraAtual.plusMinutes(minutosAdicionar);
            return !novaHora.isAfter(horario.getDataHoraMaxLaboral());
        }
        return Boolean.FALSE;
    }

    private String montarLinhasProducao(List<EtapaMontagem> etapasMontagem, int indiceLinhaMontagem, LocalDateTime inicioTrabalho) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        List<EtapaMontagem> etapasRestantes = new ArrayList<>();

        LocalDateTime dataHoraTrabalho = inicioTrabalho;

        while (!etapasMontagem.isEmpty()) {

            if (dataHoraTrabalho.isEqual(horario.getDataHoraInicioTrabalho())) {
                stringBuilder.append(TITULO_LINHA_MONTAGEM).append(indiceLinhaMontagem).append(System.lineSeparator());
            }

            Iterator<EtapaMontagem> iterator = etapasMontagem.iterator();

            while (iterator.hasNext()) {
                EtapaMontagem etapa = iterator.next();

                if (isPeriodoManhaValido(dataHoraTrabalho, etapa.getDuracao())) {
                    line = formatarLinha(dataHoraTrabalho.getHour(), dataHoraTrabalho.getMinute(), etapa.getTitulo());
                    stringBuilder.append(line).append(System.lineSeparator());
                    dataHoraTrabalho = dataHoraTrabalho.plusMinutes(etapa.getDuracao());
                    iterator.remove();
                } else if (dataHoraTrabalho.isEqual(horario.getAlmoco())) {
                    line = formatarLinha(dataHoraTrabalho.getHour(), dataHoraTrabalho.getMinute(), "Almoço");
                    stringBuilder.append(line).append(System.lineSeparator());
                    dataHoraTrabalho = horario.getAlmocoFim();
                    etapasRestantes.add(etapa);
                    iterator.remove();
                } else if (dataHoraTrabalho.isAfter(horario.getAlmoco()) && isDuracaoLaboralMinimaValida(dataHoraTrabalho, etapa.getDuracao())) {
                    line = formatarLinha(dataHoraTrabalho.getHour(), dataHoraTrabalho.getMinute(), etapa.getTitulo());
                    stringBuilder.append(line).append(System.lineSeparator());
                    dataHoraTrabalho = dataHoraTrabalho.plusMinutes(etapa.getDuracao());
                    iterator.remove();
                } else {
                    etapasRestantes.add(etapa);
                }
            }

            if (dataHoraTrabalho.isEqual(horario.getDataHoraMinLaboral()) || dataHoraTrabalho.isAfter(horario.getDataHoraMinLaboral())) {
                line = formatarLinha(dataHoraTrabalho.getHour(), dataHoraTrabalho.getMinute(), "Ginástica Laboral");
                stringBuilder.append(line).append(System.lineSeparator()).append(System.lineSeparator());
            }

            if (!etapasRestantes.isEmpty()) {
                if (dataHoraTrabalho.isBefore(horario.getAlmoco())) {
                    dataHoraTrabalho = horario.getAlmoco();
                } else if (dataHoraTrabalho.isAfter(horario.getAlmocoFim()) && dataHoraTrabalho.isAfter(horario.getDataHoraMinLaboral())) {
                    dataHoraTrabalho = horario.getDataHoraInicioTrabalho();
                }
                etapasMontagem = etapasRestantes;
                etapasRestantes = new ArrayList<>();
                indiceLinhaMontagem++;
            } else {
                dataHoraTrabalho = horario.getDataHoraMinLaboral();
                line = formatarLinha(dataHoraTrabalho.getHour(), dataHoraTrabalho.getMinute(), "Ginástica Laboral");
                stringBuilder.append(line).append(System.lineSeparator()).append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }

    private String formatarLinha(int hora, int minutos, String etapa) {
        return String.format("%02d:%02d - %s", hora, minutos, etapa);
    }
}
