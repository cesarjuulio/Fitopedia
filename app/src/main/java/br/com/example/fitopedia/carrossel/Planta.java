package br.com.example.fitopedia.carrossel;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Planta implements Serializable {
    private String contraIndicacoes;
    private String contraIndicacoesExtemporaneas;
    private String descarte;
    private String imagemDemonstracao1;
    private String imagemDemonstracao2;
    private String imagemRemedioDemonstracao;
    private String indicacao;
    private String indicacoesExtemporaneas;
    private String laboratorio;
    private String localizacao;
    private String modoPreparo;
    private String modoUso;
    private String nomeCientifico;
    private String nomePopular;
    private String parteUsada;
    private String posologia;
    private String remedio;

    public Planta(String nomePopular, String nomeCientifico, String remedio, String laboratorio, String indicacao, String posologia, String descarte, String contraIndicacoes, String parteUsada, String indicacoesExtemporaneas, String modoPreparo, String modoUso, String contraIndicacoesExtemporaneas, String localizacao, String imagemDemonstracao1, String imagemDemonstracao2, String imagemRemedioDemonstracao) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.remedio = remedio;
        this.laboratorio = laboratorio;
        this.indicacao = indicacao;
        this.posologia = posologia;
        this.descarte = descarte;
        this.contraIndicacoes = contraIndicacoes;
        this.parteUsada = parteUsada;
        this.indicacoesExtemporaneas = indicacoesExtemporaneas;
        this.modoPreparo = modoPreparo;
        this.modoUso = modoUso;
        this.contraIndicacoesExtemporaneas = contraIndicacoesExtemporaneas;
        this.localizacao = localizacao;
        this.imagemDemonstracao1 = imagemDemonstracao1;
        this.imagemDemonstracao2 = imagemDemonstracao2;
        this.imagemRemedioDemonstracao = imagemRemedioDemonstracao;
    }

    public Planta(String nomePopular, String nomeCientifico, String imagemDemonstracao1) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.imagemDemonstracao1 = imagemDemonstracao1;
    }

    public String getNomePopular() {
        return this.nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getNomeCientifico() {
        return this.nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getRemedio() {
        return this.remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getIndicacao() {
        return this.indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getPosologia() {
        return this.posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getDescarte() {
        return this.descarte;
    }

    public void setDescarte(String descarte) {
        this.descarte = descarte;
    }

    public String getContraIndicacoes() {
        return this.contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getParteUsada() {
        return this.parteUsada;
    }

    public void setParteUsada(String parteUsada) {
        this.parteUsada = parteUsada;
    }

    public String getIndicacoesExtemporaneas() {
        return this.indicacoesExtemporaneas;
    }

    public void setIndicacoesExtemporaneas(String indicacoesExtemporaneas) {
        this.indicacoesExtemporaneas = indicacoesExtemporaneas;
    }

    public String getModoPreparo() {
        return this.modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getModoUso() {
        return this.modoUso;
    }

    public void setModoUso(String modoUso) {
        this.modoUso = modoUso;
    }

    public String getContraIndicacoesExtemporaneas() {
        return this.contraIndicacoesExtemporaneas;
    }

    public void setContraIndicacoesExtemporaneas(String contraIndicacoesExtemporaneas) {
        this.contraIndicacoesExtemporaneas = contraIndicacoesExtemporaneas;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getImagemDemonstracao1() {
        return this.imagemDemonstracao1;
    }

    public void setImagemDemonstracao1(String imagemDemonstracao1) {
        this.imagemDemonstracao1 = imagemDemonstracao1;
    }

    public String getImagemDemonstracao2() {
        return this.imagemDemonstracao2;
    }

    public void setImagemDemonstracao2(String imagemDemonstracao2) {
        this.imagemDemonstracao2 = imagemDemonstracao2;
    }

    public String getImagemRemedioDemonstracao() {
        return this.imagemRemedioDemonstracao;
    }

    public void setImagemRemedioDemonstracao(String imagemRemedioDemonstracao) {
        this.imagemRemedioDemonstracao = imagemRemedioDemonstracao;
    }

    public static Planta fromCSVColumns(String[] colunas) {
        if (colunas == null || colunas.length < 17) {
            return null;
        }
        return new Planta(colunas[0].trim(), colunas[1].trim(), colunas[2].trim(), colunas[3].trim(), colunas[4].trim(), colunas[5].trim(), colunas[6].trim(), colunas[7].trim(), colunas[8].trim(), colunas[9].trim(), colunas[10].trim(), colunas[11].trim(), colunas[12].trim(), colunas[13].trim(), colunas[14].trim(), colunas[15].trim(), colunas[16].trim());
    }

    public String toString() {
        return "Planta{Nome popular: " + this.nomePopular + " | Nome científico: " + this.nomeCientifico + " | Remédio: " + this.remedio + " | Laboratório: " + this.laboratorio + " | Indicação: " + this.indicacao + " | Posologia: " + this.posologia + " | Descarte: " + this.descarte + " | Contra Indicações: " + this.contraIndicacoes + " | Parte Usada: " + this.parteUsada + " | Indicações Extemporâneas: " + this.indicacoesExtemporaneas + " | Modo de preparo: " + this.modoPreparo + " | Modo de uso: " + this.modoUso + " | Contra Indicações Extemporâneas: " + this.contraIndicacoesExtemporaneas + " | Localização: " + this.localizacao + " | Imagem Demonstração 1: " + this.imagemDemonstracao1 + " | Imagem Demonstração 2: " + this.imagemDemonstracao2 + " | Imagem Remédio Demonstração: " + this.imagemRemedioDemonstracao + "}";
    }
}
