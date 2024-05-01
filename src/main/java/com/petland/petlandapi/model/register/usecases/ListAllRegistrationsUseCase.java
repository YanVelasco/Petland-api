package com.petland.petlandapi.model.register.usecases;

import com.petland.petlandapi.model.register.dto.RegistrationResponseDTO;
import com.petland.petlandapi.model.register.entity.RegistrationEntity;
import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllRegistrationsUseCase {

    private final RegistrationRepository registrationRepository;

    public ListAllRegistrationsUseCase(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    public List<RegistrationResponseDTO> execute() {
        List<RegistrationEntity> registrationEntities = registrationRepository.findAll();
        List<RegistrationResponseDTO> registrationResponseDTOS = new ArrayList<>();
        for (RegistrationEntity registrationEntity : registrationEntities) {
            RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO(
                    registrationEntity.getId(),
                    registrationEntity.getName(),
                    registrationEntity.getProfile(),
                    registrationEntity.getAddress()
            );
            BeanUtils.copyProperties(registrationEntity, registrationResponseDTO);
            registrationResponseDTOS.add(registrationResponseDTO);
        }

        return registrationResponseDTOS;
    }
}