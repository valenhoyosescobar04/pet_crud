package co.edu.cue.petcrud.infrastructure.controllers;

import co.edu.cue.petcrud.domain.Pet;
import co.edu.cue.petcrud.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // GET /api/pets
    @GetMapping
    public List<Pet> getAllPets(
            @RequestParam(required = false) String species,
            @RequestParam(required = false) String name
    ) {
        if (species != null && !species.isBlank()) {
            return petService.getPetsBySpecies(species);
        }
        if (name != null && !name.isBlank()) {
            return petService.searchPetsByName(name);
        }
        return petService.getAllPets();
    }

    // GET /api/pets/{id}
    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    // POST /api/pets
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet created = petService.createPet(pet);
        return ResponseEntity.ok(created);
    }

    // PUT /api/pets/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id,
                                         @RequestBody Pet petDetails) {
        Pet updated = petService.updatePet(id, petDetails);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/pets/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
