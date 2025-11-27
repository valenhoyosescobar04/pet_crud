package co.edu.cue.petcrud.infrastructure.repository;

import co.edu.cue.petcrud.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findBySpeciesIgnoreCase(String species);

    List<Pet> findByNameContainingIgnoreCase(String name);
}
