package com.commerce.module.client.service;

import com.commerce.module.client.entity.Client;
import com.commerce.module.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Integer id, Client client) {
        Client existing = clientRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        return clientRepository.save(existing);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}