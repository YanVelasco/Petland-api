package com.petland.petlandapi.model.register.usecases;

import com.petland.petlandapi.model.register.dto.RegistrationRequestDTO;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlterRegistersByIdUseCase {

    private final RegistrationRepository registrationRepository;

    public AlterRegistersByIdUseCase(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public UUID execute(UUID id, RegistrationRequestDTO registrationRequestDTO){
        RegistrationEntity entity = registrationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Registration not found")
        );

        if (entity != null) {
            if (registrationRequestDTO.name() != null) {
                entity.setName(registrationRequestDTO.name());
            }
            if (registrationRequestDTO.profile() != null) {
                entity.setProfile(registrationRequestDTO.profile());
            }
            if (registrationRequestDTO.address() != null) {
                entity.setAddress(registrationRequestDTO.address());
            }
            registrationRepository.save(entity);
            return entity.getId();
        } else {
            throw new RuntimeException("Registration not found");
        }
    }
}