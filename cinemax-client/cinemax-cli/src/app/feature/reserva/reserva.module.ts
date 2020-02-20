import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservaRoutingModule } from './reserva-routing.module';
import { CrearReservaComponent } from './components/crear-reserva/crear-reserva.component';
import { ListarReservaComponent } from './components/listar-reserva/listar-reserva.component';
import { ReservaService } from './shared/services/reserva.service';
import { FormsModule } from '@angular/forms';
import { PeliculaService } from '../pelicula/shared/services/pelicula.service';
import { Module } from 'src/app/shared/shared.module';






@NgModule({
  declarations: [
    CrearReservaComponent,
    ListarReservaComponent
  ],
  imports: [
    CommonModule,
    ReservaRoutingModule,
    FormsModule, 
    Module
  ],
  providers: [ReservaService,PeliculaService]
})
export class ReservaModule { }
