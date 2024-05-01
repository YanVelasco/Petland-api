package com.petland.petlandapi.model.animal.usecases;

import com.petland.petlandapi.model.animal.dto.AnimalResponseDTO;
import com.petland.petlandapi.model.animal.entity.AnimalEntity;
import com.petland.petlandapi.model.animal.repository.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllAnimalsUseCase {

    private final AnimalRepository animalRepository;

    public ListAllAnimalsUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalResponseDTO> execute() {
        List<AnimalEntity> animalEntities = animalRepository.findAll ();
        List<AnimalResponseDTO> animalResponseDTOs = new ArrayList<> ();
        for (AnimalEntity animalEntity : animalEntities) {
            AnimalResponseDTO animalResponseDTO = new AnimalResponseDTO (
                    animalEntity.getId (),
                    animalEntity.getName (),
                    animalEntity.getBornDate (),
                    animalEntity.getSpecie ()
            );
            BeanUtils.copyProperties (animalEntity, animalResponseDTO);
            animalResponseDTOs.add (animalResponseDTO);
        }
        return animalResponseDTOs;
    }
}