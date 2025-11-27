package co.edu.cue.petcrud.services.impl;

import co.edu.cue.petcrud.domain.Pet;
import co.edu.cue.petcrud.infrastructure.repository.PetRepository;
import co.edu.cue.petcrud.services.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + id));
    }

    @Override
    public Pet createPet(Pet pet) {
        if (pet.getVaccinated() == null) {
            pet.setVaccinated(false);
        }
        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet petDetails) {
        Pet pet = getPetById(id);

        pet.setName(petDetails.getName());
        pet.setSpecies(petDetails.getSpecies());
        pet.setBreed(petDetails.getBreed());
        pet.setAge(petDetails.getAge());
        pet.setWeight(petDetails.getWeight());
        pet.setVaccinated(petDetails.getVaccinated());

        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> getPetsBySpecies(String species) {
        return petRepository.findBySpeciesIgnoreCase(species);
    }

    @Override
    public List<Pet> searchPetsByName(String name) {
        return petRepository.findByNameContainingIgnoreCase(name);
    }
}
