import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ReservaService } from '../../shared/services/reserva.service';
import { Router } from '@angular/router';
import { Reserva } from 'src/app/feature/reserva/shared/model/reserva';
import { Pelicula } from 'src/app/feature/pelicula/shared/model/pelicula';
import { PeliculaService } from 'src/app/feature/pelicula/shared/services/pelicula.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
  styleUrls: ['./crear-reserva.component.css']
})
export class CrearReservaComponent implements OnInit {

  public reserva: Reserva;
  form: NgForm

  pelicula: Pelicula[];


  constructor(private reservaService: ReservaService,
    private router: Router, private servicioPelicula: PeliculaService) { }

  ngOnInit() {
    this.reserva = new Reserva();
    this.getpeliculas();
  }

  getpeliculas() {
    this.servicioPelicula.getPeliculas().subscribe((data: any) => this.pelicula = data)
    console.log(this.pelicula)

  }

  
  OnSubmit(form: NgForm) {
    this.reservaService.create(this.reserva)
      .subscribe(Response => {
        this.router.navigate(['/principal'])
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reserva Exitosa',
          text: 'La reserva se creo con exito',
          showConfirmButton: true
        });

      });

  }

}
