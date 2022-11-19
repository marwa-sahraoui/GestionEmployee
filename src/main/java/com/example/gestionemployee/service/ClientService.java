package com.example.gestionemployee.service;

import com.example.gestionemployee.model.Client;
import com.example.gestionemployee.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid client Id: " + id));
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public void update(Client client, Long id) {

        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isPresent()) {
            Client oldClient = clientOptional.get();

            oldClient.setName(client.getName());
            clientRepository.save(client);
        } else {
            throw new IllegalStateException("client not found");
        }
    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
