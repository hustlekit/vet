package com.vet.service;

import com.vet.model.Doctor;
import com.vet.model.dao.DoctorDao;
import com.vet.model.util.DoctorMapper;
import com.vet.repository.DoctorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDao> getAll() {
        List<DoctorDao> result = new ArrayList<>();
        List<Doctor> temp = doctorRepository.findAll();
        for (Doctor v : temp) {
            result.add(DoctorMapper.map(v));
        }
        return result;
    }
}
