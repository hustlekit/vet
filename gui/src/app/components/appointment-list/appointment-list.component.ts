import { Component, OnInit } from '@angular/core';
import {StateService} from '../../services/state/state.service';
import {IAppointment} from '../../model/iappointment';
import {AppointmentService} from '../../services/appointment/appointment.service';
import {NgForm} from '@angular/forms';
import {IDoctor} from '../../model/idoctor';
import {DoctorService} from '../../services/doctor/doctor.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  appointments: IAppointment[] = [];
  doctors: IDoctor[] = [];

  constructor(
    private stateService: StateService,
    private appointmentService: AppointmentService,
    private doctorService: DoctorService
  ) { }

  ngOnInit(): void {
    this.doctors = this.doctorService.getAll();
    this.appointments = this.appointmentService.getAllByPetsIds(this.stateService.loggedUser.pets);
  }

  onSubmit(form: NgForm): void {
    console.log(form);
  }

  setDoctors(v: IDoctor[]): void {
    this.doctors = v;
  }

  setAppointments(v: IAppointment[]): void {
    this.appointments = v;
  }

}
