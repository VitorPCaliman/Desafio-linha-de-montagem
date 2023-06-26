package javaSource.classes;

class EtapaMontagem {
    private String titulo;
    private Long duracao;

    public EtapaMontagem(String titulo, Long duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getDuracao() {
        return duracao;
    }
}
