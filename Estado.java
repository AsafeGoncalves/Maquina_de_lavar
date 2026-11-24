public enum Estado {
    DESLIGADA("Desligada"),
    LIGADA("Ligada"),
    LAVANDO("Lavando"),
    PAUSADA("Pausada"),
    LAVAGEM_CONCLUIDA("Lavagem concluída"),
    CENTRIFUGANDO("Centrifugando"),
    CENTRIFUGACAO_CONCLUIDA("Centrifugação concluída");

    private final String descricao;

    Estado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
