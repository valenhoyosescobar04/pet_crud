package co.edu.cue.petcrud.services;

import co.edu.cue.petcrud.domain.Pet;

import java.util.List;

/**
 * Contrato de la capa de servicio para operaciones sobre Pet.
 * La implementación debe encargarse de la lógica de negocio y validaciones.
 */
public interface PetService {

    /**
     * Obtiene todas las mascotas almacenadas.
     *
     * @return lista de Pet
     */
    List<Pet> getAllPets();

    /**
     * Obtiene una mascota por su id.
     *
     * @param id identificador (Long)
     * @return Pet correspondiente o lanza RuntimeException si no existe
     */
    Pet getPetById(Long id);

    /**
     * Crea una nueva mascota.
     *
     * @param pet entidad Pet con los datos a persistir
     * @return la entidad persistida (con id)
     */
    Pet createPet(Pet pet);

    /**
     * Actualiza una mascota existente.
     *
     * @param id  identificador de la mascota a actualizar
     * @param pet entidad con los nuevos datos
     * @return la entidad actualizada
     */
    Pet updatePet(Long id, Pet pet);

    /**
     * Elimina una mascota por id.
     *
     * @param id identificador de la mascota a eliminar
     */
    void deletePet(Long id);

    /**
     * Lista mascotas por especie (case-insensitive).
     *
     * @param species especie a filtrar
     * @return lista de Pet
     */
    List<Pet> getPetsBySpecies(String species);

    /**
     * Busca mascotas cuyo nombre contiene el fragmento dado (case-insensitive).
     *
     * @param name fragmento de nombre
     * @return lista de Pet
     */
    List<Pet> searchPetsByName(String name);
}
