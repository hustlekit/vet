import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {StateService} from '../../services/state/state.service';
import {PetService} from '../../services/pet/pet.service';
import {IPet} from '../../model/ipet';
import {IDoctor} from '../../model/idoctor';
import {DoctorService} from '../../services/doctor/doctor.service';
import {IAppointment} from '../../model/iappointment';
import {AppointmentService} from '../../services/appointment/appointment.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent implements OnInit {

  pets: IPet[] = [];
  doctors: IDoctor[] = [];

  constructor(
    private appointmentService: AppointmentService,
    private stateService: StateService,
    private petService: PetService,
    private doctorService: DoctorService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.pets = this.petService.getAllByUserId(this.stateService.loggedUser.id);
    this.doctors = this.doctorService.getAll();
  }

  onSubmit(form: NgForm): void {
    console.log(form);
    let tempPetId: number;
    let tempDocId: number;
    this.pets.forEach(v => {
      if (v.name === form.value.pet) {
        tempPetId = v.id;
      }
    });
    this.doctors.forEach(v => {
      if (v.name === form.value.doctor) {
        tempDocId = v.id;
      }
    });
    const result: IAppointment = {
      id: null,
      date: form.value.date,
      petId: tempPetId,
      petName: form.value.pet,
      doctorId: tempDocId,
      doctorName: form.value.doctor,
      userId: this.stateService.loggedUser.id
    };
    console.log(result);
    this.saveAppointment(result);
    // this.appointmentService.save(result);
    // this.router.navigate(['/appointment-list']);
  }

  saveAppointment(appointment: IAppointment): void {
    this.appointmentService.save(appointment);
  }
}
