import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private httpClient:HttpClient) { }

  private _restCountriesUrl="https://restcountries.com/v3.1/all";

  returnFn(){
    return this.httpClient.get(this._restCountriesUrl);
  }
}
