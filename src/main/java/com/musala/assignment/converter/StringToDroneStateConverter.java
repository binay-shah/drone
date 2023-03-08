package com.musala.assignment.converter;


import com.musala.assignment.dto.DroneState;
import org.springframework.core.convert.converter.Converter;

@RequestParameterConverter
public class StringToDroneStateConverter implements Converter<String, DroneState> {
    @Override
    public DroneState convert(String source) {
        return DroneState.decode(source);
    }
}
