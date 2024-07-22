package com.binary_dot.ehr_backend.api.drug_manufacturer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugManufacturerMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DrugManufacturerDto mapToDto(DrugManufacturer drugManufacturer) {
        return modelMapper.map(drugManufacturer, DrugManufacturerDto.class);
    }

    public DrugManufacturer mapToEntity(DrugManufacturerDto drugManufacturerDto) {
        return modelMapper.map(drugManufacturerDto, DrugManufacturer.class);
    }

}
