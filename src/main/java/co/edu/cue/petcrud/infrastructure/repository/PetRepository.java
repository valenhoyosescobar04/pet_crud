package co.edu.cue.petcrud.infrastructure.repository;

import co.edu.cue.petcrud.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio Spring Data JPA para la entidad Pet.
 * Proporciona operaciones CRUD básicas y consultas derivadas para búsquedas
 * por especie y por nombre (case-insensitive).
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * Busca mascotas por especie (sin distinguir mayúsculas/minúsculas).
     *
     * @param species especie a buscar (String)
     * @return lista de mascotas que coinciden con la especie
     */
    List<Pet> findBySpeciesIgnoreCase(String species);

    /**
     * Busca mascotas cuyo nombre contiene el fragmento dado (case-insensitive).
     *
     * @param name fragmento de nombre a buscar (String)
     * @return lista de mascotas con nombre que contiene el fragmento
     */
    List<Pet> findByNameContainingIgnoreCase(String name);
}
