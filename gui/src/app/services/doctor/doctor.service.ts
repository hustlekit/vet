import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {IDoctor} from '../../model/idoctor';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  baseUrl: string = environment.APIEndpoint + '/doctor';

  constructor(
    private http: HttpClient
  ) { }

  getAll(): IDoctor[] {
    const doctors: IDoctor[] = [];
    const url = this.baseUrl + '/getAll';
    this.http.get(url).subscribe((data: IDoctor[]) => {
      data.forEach(value => {
        doctors.push(value);
      });
    });
    return doctors;
  }
}
