package com.petland.petlandapi.model.animal.usecases;

import com.petland.petlandapi.model.animal.dto.AnimalRequestDTO;
import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateAnimalUseCase {
    private final AnimalRepository animalRepository;
    private final RegistrationRepository registrationRepository;

    public CreateAnimalUseCase(AnimalRepository animalRepository, RegistrationRepository registrationRepository) {
        this.animalRepository = animalRepository;
        this.registrationRepository = registrationRepository;
    }
    public UUID execute(AnimalRequestDTO animalRequestDTO) {

    // Check if the registration id exists
    if (registrationRepository.findById(animalRequestDTO.registrationId ()).isEmpty()) {
        throw new RuntimeException("Registration not found");
    }

    AnimalEntity animalEntity = new AnimalEntity();
    BeanUtils.copyProperties(animalRequestDTO, animalEntity);
    return animalRepository.save(animalEntity).getId();
}
}
