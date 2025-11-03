package br.com.example.fitopedia;

public class Mensagem {
    private String texto;
    private boolean isUsuario;

    public Mensagem(String texto, boolean isUsuario) {
        this.texto = texto;
        this.isUsuario = isUsuario;
    }

    public String getTexto() { return texto; }
    public boolean isUsuario() { return isUsuario; }
}
