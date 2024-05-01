package com.petland.petlandapi.model.register.usecases;

import com.petland.petlandapi.model.register.dto.RegistrationRequestDTO;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateRegistrationUseCase {
    private final RegistrationRepository registrationRepository;

    public CreateRegistrationUseCase(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public UUID execute(RegistrationRequestDTO registrationRequestDTO) {
        RegistrationEntity registration = new RegistrationEntity();
        BeanUtils.copyProperties(registrationRequestDTO, registration);
        registration = registrationRepository.save(registration);
        return registration.getId();
    }
}
