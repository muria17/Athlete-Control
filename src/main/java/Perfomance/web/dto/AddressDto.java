package Perfomance.web.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        String numero) {

}
