package co.edu.cue.petcrud.domain;

import jakarta.persistence.*;

/**
 * Entidad JPA que representa una mascota (Pet) en la base de datos.
 *
 * Campos principales:
 * - id: Identificador autogenerado (Long).
 * - name: Nombre de la mascota (String).
 * - species: Especie, por ejemplo "perro" o "gato" (String).
 * - breed: Raza (String).
 * - age: Edad en años (Integer).
 * - weight: Peso en kilogramos (Double).
 * - vaccinated: Indica si está vacunado (Boolean).
 *
 * Esta clase se usa como DTO de persistencia y transporta los datos entre
 * la capa de repositorio y las capas superiores (servicio/controlador).
 */
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String species;    // perro, gato, etc.

    private String breed;      // raza

    private Integer age;       // años

    private Double weight;     // peso en kg

    private Boolean vaccinated;

    public Pet() {
    }

    /**
     * Constructor principal de conveniencia.
     *
     * @param name       nombre de la mascota (String)
     * @param species    especie (String)
     * @param breed      raza (String)
     * @param age        edad en años (Integer)
     * @param weight     peso en kg (Double)
     * @param vaccinated si está vacunada (Boolean)
     */
    public Pet(String name, String species, String breed, Integer age, Double weight, Boolean vaccinated) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.vaccinated = vaccinated;
    }

    // Getters y setters: usados por frameworks (JPA, Jackson) y por la lógica de negocio.

    /**
     * @return id autogenerado (Long) — puede ser null antes de persistir la entidad.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return nombre de la mascota (String)
     */
    public String getName() {
        return name;
    }

    /**
     * @return especie (String)
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return raza (String)
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @return edad en años (Integer)
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @return peso en kilogramos (Double)
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @return true si la mascota está vacunada, false en caso contrario o null si no se ha establecido.
     */
    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
