package co.edu.cue.petcrud.infrastructure.controllers;

import co.edu.cue.petcrud.domain.Pet;
import co.edu.cue.petcrud.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones CRUD sobre mascotas (Pet).
 *
 * Rutas principales:
 * - GET /api/pets : listar mascotas (opcionalmente filtrar por species o name)
 * - GET /api/pets/{id} : obtener mascota por id
 * - POST /api/pets : crear una nueva mascota
 * - PUT /api/pets/{id} : actualizar una mascota existente
 * - DELETE /api/pets/{id} : eliminar una mascota
 */
@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // GET /api/pets
    /**
     * Obtiene la lista de mascotas. Si se proporciona el parámetro "species",
     * filtra por especie (case-insensitive); si se proporciona "name" busca por
     * coincidencia parcial en el nombre.
     *
     * @param species (opcional) especie a filtrar, tipo String
     * @param name    (opcional) fragmento de nombre a buscar, tipo String
     * @return lista de Pet que cumplen el criterio
     */
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
    /**
     * Obtiene una mascota por su id.
     *
     * @param id identificador de la mascota (Long)
     * @return la entidad Pet correspondiente. Si no existe, el servicio lanza una excepción.
     */
    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    // POST /api/pets
    /**
     * Crea una nueva mascota.
     *
     * @param pet objeto Pet recibido en el body (JSON -> Pet)
     * @return ResponseEntity con la entidad creada (HTTP 200)
     */
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet created = petService.createPet(pet);
        return ResponseEntity.ok(created);
    }

    // PUT /api/pets/{id}
    /**
     * Actualiza una mascota existente.
     *
     * @param id         identificador de la mascota a actualizar (Long)
     * @param petDetails objeto Pet con los nuevos valores (JSON -> Pet)
     * @return ResponseEntity con la entidad actualizada (HTTP 200)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id,
                                         @RequestBody Pet petDetails) {
        Pet updated = petService.updatePet(id, petDetails);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/pets/{id}
    /**
     * Elimina una mascota por id.
     *
     * @param id identificador de la mascota a eliminar (Long)
     * @return ResponseEntity con no-content (HTTP 204)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
