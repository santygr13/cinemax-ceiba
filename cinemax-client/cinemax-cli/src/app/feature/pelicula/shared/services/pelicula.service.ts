import { Injectable } from '@angular/core';
import { Pelicula } from '../model/pelicula';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { BaseService } from 'src/app/core/services/base.service';
import { environment } from 'src/environments/environment';

@Injectable(
)
export class PeliculaService extends BaseService {

  constructor(protected http: HttpClient) {
    super(http)
  }
 




  public getPeliculas() {
    return this.doGet<Pelicula[]>(`${environment.endpoint}/pelicula`)
  }

  
  public create(pelicula: Pelicula){
    return this.doPost<Pelicula,boolean>(`${environment.endpoint}/pelicula`,pelicula)

  }



}
