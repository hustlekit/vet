package com.vet.model.util;

import com.vet.model.Appointment;
import com.vet.model.Doctor;
import com.vet.model.dao.DoctorDao;

import java.util.ArrayList;
import java.util.List;

public class DoctorMapper {

    public static DoctorDao map(Doctor source) {
        DoctorDao result = new DoctorDao();
        List<Long> appointmentsIds = new ArrayList<>();
        for (Appointment appointment : source.getAppointments()) {
            appointmentsIds.add(appointment.getId());
        }
        result.setId(source.getId());
        result.setName(source.getFirstName() + " " + source.getLastName());
        result.setAppointments(appointmentsIds);
        return result;
    }
}
