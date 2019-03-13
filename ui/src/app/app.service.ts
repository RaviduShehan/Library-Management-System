import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs/index';

@Injectable()
export class AppService {
  private serviceUrl = '/api/summary';
  private dataPostTestUrl = '/api/postTest';
  private dis = '/api/dis';


  constructor(private http: HttpClient) {
  }

//Testing Methods
public sendData(): Observable<any> {
  return this.http.post(this.dataPostTestUrl, {});
}

}
