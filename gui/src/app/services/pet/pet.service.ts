import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {IPet} from '../../model/ipet';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  baseUrl: string = environment.APIEndpoint + '/pet';

  constructor(
    private http: HttpClient
  ) { }

  getAllByUserId(id: number): IPet[] {
    const pets: IPet[] = [];
    const url = this.baseUrl + '/getAllByUserId/' + id;
    this.http.get(url).subscribe((data: IPet[]) => {
      data.forEach(value => {
        pets.push(value);
      });
    });
    return pets;
  }
}
