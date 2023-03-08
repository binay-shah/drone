package com.musala.assignment.converter;


import com.musala.assignment.dto.DroneState;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Component
@Converter(autoApply = true)
public class DroneStateConverter implements AttributeConverter<DroneState, String> {


    @Override
    public String convertToDatabaseColumn(DroneState droneState) {
        return Optional.ofNullable(droneState).map(DroneState::getCode).orElse(null);
    }

    @Override
    public DroneState convertToEntityAttribute(String dbData) {
        return DroneState.decode(dbData);
    }


}
