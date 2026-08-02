package mg.aina.commerce.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.aina.commerce.client.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}