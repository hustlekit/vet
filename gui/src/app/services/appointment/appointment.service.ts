import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {IAppointment} from '../../model/iappointment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  baseUrl: string = environment.APIEndpoint + '/appointment';

  constructor(
    private http: HttpClient
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
}
