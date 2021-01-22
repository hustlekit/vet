package com.vet.model.util;

import com.vet.model.Appointment;
import com.vet.model.Doctor;
import com.vet.model.dao.AppointmentDao;
import com.vet.service.DoctorService;
import com.vet.service.PetService;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    private PetService petService;
    private DoctorService doctorService;

    public AppointmentMapper(PetService petService, DoctorService doctorService) {
        this.petService = petService;
        this.doctorService = doctorService;
    }

    public AppointmentDao map(Appointment source) {
        AppointmentDao result = new AppointmentDao();
        result.setId(source.getId());
        result.setDate(source.getDate());
        result.setPetId(source.getPet().getId());
        result.setPetName(source.getPet().getName());
        result.setDoctorId(source.getDoctor().getId());
        result.setDoctorName(source.getDoctor().getFirstName() + " " + source.getDoctor().getLastName());
        result.setUserId(source.getPet().getOwner().getId());
        return  result;
    }

    public Appointment map(AppointmentDao source) {
        Appointment result = new Appointment();
//        result.setId(null);
        result.setDate(source.getDate());
        result.setDoctor(doctorService.getById(source.getDoctorId()));
        result.setPet(petService.getById(source.getPetId()));
        return result;
    }
}
