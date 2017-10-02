import { Injectable } from '@angular/core';

import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class PartService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  deletePart(carId: string, partName: string): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/cars/parts/' + carId + '/' + partName)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Beep Beep! ERROR!', error);
    return Promise.reject(error.message || error);
  }

}
