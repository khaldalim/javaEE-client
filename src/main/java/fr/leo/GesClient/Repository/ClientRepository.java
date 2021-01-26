package fr.leo.GesClient.Repository;

import fr.leo.GesClient.entities.Client;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Page<Client> findByNomClientContains(String mc, Pageable pePageable);

}
