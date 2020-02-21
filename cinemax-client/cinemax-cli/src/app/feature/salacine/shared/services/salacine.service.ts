import { Injectable } from '@angular/core';
import { SalaCine } from '../model/salacine';
import { HttpClient} from '@angular/common/http';
import { BaseService } from 'src/app/core/services/base.service';
import { environment } from 'src/environments/environment';

@Injectable(
  )
export class SalacineService  extends BaseService{

  constructor(protected http: HttpClient) {
    super(http)
  }

  



  public getSalas(){
    return this.doGet<SalaCine[]>(`${environment.endpoint}/salacine`)
  }


  public create(salacine:SalaCine) {
    return this.doPost<SalaCine,boolean>(`${environment.endpoint}/salacine`,salacine)
  }



}
