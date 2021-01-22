package com.vet.model.util;

import com.vet.model.Appointment;
import com.vet.model.dao.AppointmentDao;

public class AppointmentMapper {

    public static AppointmentDao map(Appointment source) {
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
}
