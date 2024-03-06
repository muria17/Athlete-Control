package Perfomance.web.dto;

import java.util.Date;

public class AthleteDto {
    private Long id;
    private String nome;
    private String peso;
    private String altura;
    private Date dataInicio;
    private int idade;
    private AddressDto endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public AddressDto getEndereco() {
        return endereco;
    }

    public void setEndereco(AddressDto endereco) {
        this.endereco = endereco;
    }
}
