package co.edu.cue.petcrud.services;

import co.edu.cue.petcrud.domain.Pet;

import java.util.List;

public interface PetService {

    List<Pet> getAllPets();

    Pet getPetById(Long id);

    Pet createPet(Pet pet);

    Pet updatePet(Long id, Pet petDetails);

    void deletePet(Long id);

    List<Pet> getPetsBySpecies(String species);

    List<Pet> searchPetsByName(String name);
}
