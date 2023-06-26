import javaSource.classes.Arquivo;
import javaSource.classes.HorariosTrabalho;
import javaSource.classes.MontagemLinhaProducao;

import java.time.LocalDate;


/**
 * Classe responsável por executar a aplicação.
 */
public class Executor {

    public static void main(String[] args) {
        try {
            HorariosTrabalho horario = new HorariosTrabalho(LocalDate.now());
            Arquivo arquivo = new Arquivo("javaSource/resource/input.txt");
            MontagemLinhaProducao linhaProducao = new MontagemLinhaProducao(horario, arquivo);
            linhaProducao.executar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
