package br.dev.unifametro.aluno.agendaOnline.mapper.address;


import br.dev.unifametro.aluno.agendaOnline.domain.business.Address;
import br.dev.unifametro.aluno.agendaOnline.dto.address.AddressRequestDTO;
import br.dev.unifametro.aluno.agendaOnline.dto.address.AddressResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "business.id", source = "businessId")
    Address requestDtoToAddress(AddressRequestDTO addressRequestDTO);

    @Mapping(target = "businessId", source = "business.id")
    AddressResponseDTO addressToResponseDTO(Address address);
}