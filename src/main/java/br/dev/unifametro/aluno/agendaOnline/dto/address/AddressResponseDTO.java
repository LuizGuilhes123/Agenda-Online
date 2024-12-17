package br.dev.unifametro.aluno.agendaOnline.dto.address;

import java.util.UUID;

public record AddressResponseDTO(
        UUID externalId,
        String street,
        String number,
        String city,
        String state,
        String zip,
        Long businessId
) {
}