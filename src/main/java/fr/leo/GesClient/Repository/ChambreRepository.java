package fr.leo.GesClient.Repository;

import fr.leo.GesClient.entities.Chambre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

    
    
}
