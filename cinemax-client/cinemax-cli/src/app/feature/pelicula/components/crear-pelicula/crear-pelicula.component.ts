import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pelicula } from '../../shared/model/pelicula';
import { PeliculaService } from '../../shared/services/pelicula.service';
import { NgForm } from '@angular/forms';
import { SalacineService } from '../../../salacine/shared/services/salacine.service';
import { SalaCine } from '../../../salacine/shared/model/salacine';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-crear-pelicula',
  templateUrl: './crear-pelicula.component.html',
  styleUrls: ['./crear-pelicula.component.css']
})
export class CrearPeliculaComponent implements OnInit {


  public pelicula: Pelicula = new Pelicula();
  form: NgForm;
  public salaCine: SalaCine[];


  constructor(private peliculaService: PeliculaService, private router: Router, private salaServicio: SalacineService) { }


  ngOnInit() {
    this.getSalas();

  }

  getSalas() {
    this.salaServicio.getSalas().subscribe((data: any) => {
      this.salaCine = data;
      console.log(this.salaCine)
    });
  }

  OnSubmit(form: NgForm) {
    console.log(this.pelicula);
    this.peliculaService.create(this.pelicula)
      .subscribe(Response => {
        this.router.navigate(['/principal'])
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Registro Exitoso',
          text: 'La pelicula se creo con exito',
          showConfirmButton: true
        });

      });

  }

}
