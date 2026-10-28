package com.example.healthManagement.dto;
import com.example.healthManagement.entity.patient;
import jakarta.persistence.Entity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface patientMapper {

    patient toentity(patientRequest pt);

    patientResponse toResponce(patient p);

    void updatePatientFromRequest(patientRequest Req, @MappingTarget patient pt);
}