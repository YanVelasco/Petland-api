package com.petland.petlandapi.model.register.usecases;

import com.petland.petlandapi.model.register.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteRegistrationIdUseCase {

    private final RegistrationRepository registrationRepository;
    public DeleteRegistrationIdUseCase(RegistrationRepository registrationRepository){
        this.registrationRepository = registrationRepository;
    }


    public void execute(UUID id){
        var entity = registrationRepository.findById (id).orElseThrow (
                () -> new RuntimeException ("Animal not found")
        );

        if (entity != null) {
            registrationRepository.deleteById (id);
        }
    }
}
