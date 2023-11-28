package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.modelos.exception.ErroDeConversaoDeAno;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>  {
   @SerializedName("Nome")
    private String nome;
    @SerializedName("Ano")
    private int anoDeLancamento;

    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloTeste tituloTeste) {
        this.nome = tituloTeste.title();
        if (tituloTeste.year().length() > 4){
            throw new ErroDeConversaoDeAno("Não conseguiu converter o ano porque tem mais de 4 carctere");
        }
        this.anoDeLancamento = Integer.valueOf(tituloTeste.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloTeste.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return  "nome=  " + nome +
                " Ano de lançamento=  " + anoDeLancamento
                + "     Duração  " + duracaoEmMinutos + " min";
    }
}
