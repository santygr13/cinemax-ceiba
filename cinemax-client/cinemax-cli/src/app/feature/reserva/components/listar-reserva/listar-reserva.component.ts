import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { ReservaService } from '../../shared/services/reserva.service';

@Component({
  selector: 'app-listar-reserva',
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.css']
})
export class ListarReservaComponent implements OnInit {


  reserva: Reserva[]


  constructor(private reservaService: ReservaService) { }

  ngOnInit() {
    this.getReservas()
  }

  getReservas() {
    this.reservaService.getRservas().subscribe((data: any) => {
      data.forEach(obj => obj.selector = false);
      this.reserva = data;
    });
  }

}
