package com.vet.service;

import com.vet.model.Appointment;
import com.vet.model.Pet;
import com.vet.model.dao.AppointmentDao;
import com.vet.model.util.AppointmentMapper;
import com.vet.repository.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AppointmentService {

    private PetService petService;
    private AppointmentRepository appointmentRepository;
    private AppointmentMapper mapper;

    public AppointmentService(PetService petService, AppointmentRepository appointmentRepository, AppointmentMapper mapper) {
        this.petService = petService;
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    public List<AppointmentDao> getAllByPetsIds(List<Long> ids){
        List<AppointmentDao> result = new ArrayList<>();
        List<Appointment> temp = new ArrayList<>();
        for (Long id : ids) {
            Pet tempPet = petService.getById(id);
            List<Appointment> tempAppList = appointmentRepository.findAppointmentsByPet(tempPet);
            temp = Stream.concat(temp.stream(), tempAppList.stream()).collect(Collectors.toList());
        }
        for (Appointment app : temp) {
            result.add(mapper.map(app));
        }
        return result;
    }

    public void save(AppointmentDao appointmentDao) {
        appointmentRepository.save(mapper.map(appointmentDao));
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
