package br.dev.unifametro.aluno.agendaOnline.service.address;


import br.dev.unifametro.aluno.agendaOnline.domain.business.Address;
import br.dev.unifametro.aluno.agendaOnline.dto.address.AddressRequestDTO;
import br.dev.unifametro.aluno.agendaOnline.dto.address.AddressResponseDTO;
import br.dev.unifametro.aluno.agendaOnline.mapper.address.AddressMapper;
import br.dev.unifametro.aluno.agendaOnline.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public AddressResponseDTO create(AddressRequestDTO addressRequestDTO) {
        Address address = AddressMapper.INSTANCE.requestDtoToAddress(addressRequestDTO);
        address.setExternalID(UUID.randomUUID());
        Address savedAddress = addressRepository.save(address);
        return AddressMapper.INSTANCE.addressToResponseDTO(savedAddress);
    }

    public AddressResponseDTO getById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return AddressMapper.INSTANCE.addressToResponseDTO(address);
    }

    public List<AddressResponseDTO> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(AddressMapper.INSTANCE::addressToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AddressResponseDTO update(Long id, AddressRequestDTO addressRequestDTO) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        Address updatedAddress = AddressMapper.INSTANCE.requestDtoToAddress(addressRequestDTO);
        updatedAddress.setId(existingAddress.getId());
        updatedAddress.setExternalID(existingAddress.getExternalID());

        Address savedAddress = addressRepository.save(updatedAddress);
        return AddressMapper.INSTANCE.addressToResponseDTO(savedAddress);
    }

    @Transactional
    public void delete(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}