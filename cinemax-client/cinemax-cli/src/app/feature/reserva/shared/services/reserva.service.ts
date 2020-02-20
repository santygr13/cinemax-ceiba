import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from '../model/reserva';

import { BaseService } from 'src/app/core/services/base.service';
import { environment } from 'src/environments/environment';

@Injectable()
export class ReservaService extends BaseService{

  constructor(protected http: HttpClient) {
    super(http)
  }


 

  getRservas() {
    return this.doGet<Reserva[]>(`${environment.endpoint}/reserva`)
  }


  create(reserva: Reserva) {
    return this.doPost<Reserva,boolean>(`${environment.endpoint}/reserva`,reserva)

  }


}
