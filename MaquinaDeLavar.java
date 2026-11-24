public class MaquinaDeLavar {

    private Estado estado;
    private boolean tampaAberta;

    public MaquinaDeLavar() {
        this.estado = Estado.DESLIGADA;
        this.tampaAberta = false;
    }

    public boolean ligar() {
        if (estado != Estado.DESLIGADA) {
            return negar("A máquina já está ligada.");
        }
        estado = Estado.LIGADA;
        return ok("Máquina ligada.");
    }

    public boolean desligar() {
        if (estado == Estado.DESLIGADA) {
            return negar("A máquina já está desligada.");
        }
        if (estado == Estado.LAVANDO || estado == Estado.CENTRIFUGANDO || estado == Estado.PAUSADA) {
            return negar("Não é possível desligar durante a lavagem, pausa ou centrifugação.");
        }
        estado = Estado.DESLIGADA;
        return ok("Máquina desligada.");
    }

    public boolean iniciarLavagem() {
        if (estado == Estado.DESLIGADA) {
            return negar("Máquina desligada não pode iniciar a lavagem.");
        }
        if (estado != Estado.LIGADA) {
            return negar("Não é possível iniciar a lavagem no estado '" + estado.getDescricao() + "'.");
        }
        if (tampaAberta) {
            return negar("A lavagem só pode ser iniciada com a tampa fechada.");
        }
        estado = Estado.LAVANDO;
        return ok("Lavagem iniciada.");
    }

    public boolean pausarLavagem() {
        if (estado == Estado.DESLIGADA) {
            return negar("Máquina desligada não pode ser pausada.");
        }
        if (estado != Estado.LAVANDO) {
            return negar("Só é possível pausar uma lavagem em andamento.");
        }
        estado = Estado.PAUSADA;
        return ok("Lavagem pausada.");
    }

    public boolean retomarLavagem() {
        if (estado != Estado.PAUSADA) {
            return negar("Só é possível retomar uma lavagem pausada.");
        }
        if (tampaAberta) {
            return negar("Feche a tampa antes de retomar a lavagem.");
        }
        estado = Estado.LAVANDO;
        return ok("Lavagem retomada.");
    }

    public boolean concluirLavagem() {
        if (estado != Estado.LAVANDO) {
            return negar("Não há lavagem em andamento para concluir.");
        }
        estado = Estado.LAVAGEM_CONCLUIDA;
        return ok("Lavagem concluída.");
    }

    public boolean iniciarCentrifugacao() {
        if (estado != Estado.LAVAGEM_CONCLUIDA) {
            return negar("A centrifugação só pode ser iniciada após a lavagem concluída.");
        }
        if (tampaAberta) {
            return negar("Feche a tampa antes de centrifugar.");
        }
        estado = Estado.CENTRIFUGANDO;
        return ok("Centrifugação iniciada.");
    }

    public boolean concluirCentrifugacao() {
        if (estado != Estado.CENTRIFUGANDO) {
            return negar("Não há centrifugação em andamento para concluir.");
        }
        estado = Estado.CENTRIFUGACAO_CONCLUIDA;
        return ok("Centrifugação concluída.");
    }

    public boolean abrirTampa() {
        if (estado == Estado.LAVANDO || estado == Estado.CENTRIFUGANDO) {
            return negar("A tampa não pode ser aberta durante a lavagem ou centrifugação.");
        }
        if (tampaAberta) {
            return negar("A tampa já está aberta.");
        }
        tampaAberta = true;
        return ok("Tampa aberta.");
    }

    public boolean fecharTampa() {
        if (!tampaAberta) {
            return negar("A tampa já está fechada.");
        }
        tampaAberta = false;
        return ok("Tampa fechada.");
    }

    public Estado getEstado() {
        return estado;
    }

    public boolean isTampaAberta() {
        return tampaAberta;
    }

    private boolean negar(String motivo) {
        System.out.println("   [NEGADO] " + motivo);
        return false;
    }

    private boolean ok(String mensagem) {
        System.out.println("   [OK] " + mensagem);
        return true;
    }

    @Override
    public String toString() {
        return "Estado: " + estado.getDescricao() + " | Tampa: " + (tampaAberta ? "aberta" : "fechada");
    }
}
