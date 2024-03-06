package Perfomance.web.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Table(name = "athlete")
@Entity(name = "Athlete")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Athlete {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Size(max = 100)
    @Column(name = "peso", nullable = false, length = 100)
    private String peso;
    @Size(max = 6)
    @Column(name = "altura", nullable = false, length = 6)
    private String altura;
    @Column(name = "dataInicio", nullable = false)
    private Date dataInicio;
    @Column(name = "idade", nullable = false)
    private int idade;
    @Embedded
    private Address endereco;
    private Boolean ativo;

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

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }


    public void delete() {
        this.ativo = false;
    }
}
