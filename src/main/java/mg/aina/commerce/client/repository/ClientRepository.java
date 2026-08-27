package mg.aina.commerce.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mg.aina.commerce.client.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {
}