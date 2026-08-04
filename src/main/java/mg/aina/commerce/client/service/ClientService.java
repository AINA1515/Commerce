package mg.aina.commerce.client.service;

import org.springframework.stereotype.Service;

import mg.aina.commerce.client.dto.ClientDTO;
import mg.aina.commerce.client.entity.Client;
import mg.aina.commerce.client.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ClientDTO findById(Integer id) {
        return clientRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ClientDTO save(ClientDTO dto) {
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        return toDTO(clientRepository.save(client));
    }

    public ClientDTO update(Integer id, ClientDTO dto) {
        Client existing = clientRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setEmail(dto.getEmail());
        existing.setTelephone(dto.getTelephone());
        return toDTO(clientRepository.save(existing));
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO toDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getEmail(),
                client.getTelephone(),
                client.getDateCreation()
        );
    }
}
