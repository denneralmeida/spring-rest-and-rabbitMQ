package br.com.xbrain.projeto.model.enums;

public enum UF {

    PR("Paraná"), RS("Rio Grande do Sul"), SC("Santa Catarina");

    private UF(String _estado) {
        this.estado = _estado;
    }

    private String estado;

}
