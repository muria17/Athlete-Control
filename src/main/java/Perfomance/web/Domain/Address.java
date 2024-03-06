package Perfomance.web.Domain;

import Perfomance.web.dto.AddressDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Size(max = 100)
    @Column(name = "logradouro", nullable = false, length = 100)
    private String logradouro;
    @Size(max = 100)
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;
    @Size(max = 9)
    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    @Size(max = 100)
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;

    @Size(max = 100)
    @Column(name = "complemento", nullable = false, length = 100)
    private String complemento;
    @Size(max = 20)
    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    public Address(AddressDto endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }
}
