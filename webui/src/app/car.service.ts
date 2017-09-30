import { Injectable } from '@angular/core';
import { Car } from './car';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class CarService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  getCars(): Promise<Car[]> {
    return this.http.get(this.baseUrl + '/api/cars/')
      .toPromise()
      .then(response => response.json() as Car[])
      .catch(this.handleError);
  }

  createCar(car: Car): Promise<Car> {
    return this.http.post(this.baseUrl + '/api/cars/', car)
      .toPromise().then(response =>  response.json() as Car)
      .catch(this.handleError);
  }

  updateCar(car: Car): Promise<Car> {
    return this.http.put(this.baseUrl + '/api/cars/' + car.id, car)
      .toPromise()
      .then(response => response.json() as Car)
      .catch(this.handleError);
  }

  deleteCar(id: string): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/cars/' + id)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Beep Beep! ERROR!', error);
    return Promise.reject(error.message || error);
  }
}
