import { Component, OnInit } from '@angular/core';
import {StateService} from '../../services/state/state.service';
import {IAppointment} from '../../model/iappointment';
import {AppointmentService} from '../../services/appointment/appointment.service';
import {NgForm} from '@angular/forms';
import {IDoctor} from '../../model/idoctor';
import {DoctorService} from '../../services/doctor/doctor.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  appointments: IAppointment[] = [];
  doctors: IDoctor[] = [];

  constructor(
    private router: Router,
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

  appointmentForm(): void {
    this.router.navigate(['/appointment-form']);
  }

  delete(id: number): void {
    console.log(id);
    this.appointmentService.delete(id);
  }

  setDoctors(v: IDoctor[]): void {
    this.doctors = v;
  }

}
