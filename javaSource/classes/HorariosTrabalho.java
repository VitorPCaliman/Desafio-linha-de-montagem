package javaSource.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Classe responsável por estabelecer os horários utilizados para as validações.
 * Esta classe recebe a data atual e realiza a definição dos atributos de horário.
 */
public class HorariosTrabalho {

    private LocalDateTime dataHoraInicioTrabalho;
    private LocalDateTime almoco;
    private LocalDateTime almocoFim;
    private LocalDateTime dataHoraMinLaboral;
    private LocalDateTime dataHoraMaxLaboral;

    /**
     * Construtor que recebe a data atual e inicializa os horários de trabalho.
     *
     * @param dataAtual a data atual
     */
    public HorariosTrabalho(LocalDate dataAtual) {
        LocalTime horaInicioTrabalho = LocalTime.of(9, 0);
        LocalTime horaAlmocoInicio = LocalTime.of(12, 0);
        LocalTime horaAlmocoFim = LocalTime.of(13, 0);
        LocalTime horaMinLaboral = LocalTime.of(16, 0);
        LocalTime horaMaxLaboral = LocalTime.of(17, 0);

        dataHoraInicioTrabalho = LocalDateTime.of(dataAtual, horaInicioTrabalho);
        almoco = LocalDateTime.of(dataAtual, horaAlmocoInicio);
        dataHoraMinLaboral = LocalDateTime.of(dataAtual, horaMinLaboral);
        dataHoraMaxLaboral = LocalDateTime.of(dataAtual, horaMaxLaboral);
        almocoFim = LocalDateTime.of(dataAtual, horaAlmocoFim);
    }

    /**
     * Obtém a data e hora de início do trabalho.
     *
     * @return a data e hora de início do trabalho
     */
    public LocalDateTime getDataHoraInicioTrabalho() {
        return dataHoraInicioTrabalho;
    }

    /**
     * Obtém o horário do início do intervalo de almoço.
     *
     * @return o horário do início do intervalo de almoço
     */
    public LocalDateTime getAlmoco() {
        return almoco;
    }

    /**
     * Obtém o horário do fim do intervalo de almoço.
     *
     * @return o horário do fim do intervalo de almoço
     */
    public LocalDateTime getAlmocoFim() {
        return almocoFim;
    }

    /**
     * Obtém a data e hora mínima de trabalho.
     *
     * @return a data e hora mínima de trabalho
     */
    public LocalDateTime getDataHoraMinLaboral() {
        return dataHoraMinLaboral;
    }

    /**
     * Obtém a data e hora máxima de trabalho.
     *
     * @return a data e hora máxima de trabalho
     */
    public LocalDateTime getDataHoraMaxLaboral() {
        return dataHoraMaxLaboral;
    }
}
