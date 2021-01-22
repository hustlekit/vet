import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {IAppointment} from '../../model/iappointment';
import {Router} from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  baseUrl: string = environment.APIEndpoint + '/appointment';

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getAllByPetsIds(ids: number[]): IAppointment[] {
    const url = this.baseUrl + '/getAllByPetsIds';
    const result: IAppointment[] = [];
    this.http.post(url, ids, httpOptions).subscribe((v: IAppointment[]) => {
      v.forEach(value => {
        result.push(value);
      });
    });
    return result;
  }

  save(appointment: IAppointment): void {
    const url = this.baseUrl + '/save';
    console.log(appointment);
    this.http.post(url, appointment, httpOptions)
      .subscribe(result => {
        console.log(result);
      });
    this.router.navigate(['/appointment-list']);
  }

  delete(id: number): void {
    const url = this.baseUrl + '/delete/' + id;
    console.log(id);
    this.http.delete(url)
      .subscribe(result => {
        console.log(result);
      });
    this.router.navigate(['/appointment-list']);
  }
}
