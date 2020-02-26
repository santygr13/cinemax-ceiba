import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservaRoutingModule } from './reserva-routing.module';
import { CrearReservaComponent } from './components/crear-reserva/crear-reserva.component';
import { ListarReservaComponent } from './components/listar-reserva/listar-reserva.component';
import { ReservaService } from './shared/services/reserva.service';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { PeliculaService } from 'src/app/shared/services/pelicula.service';


@NgModule({
  declarations: [
    CrearReservaComponent,
    ListarReservaComponent
  ],
  imports: [
    CommonModule,
    ReservaRoutingModule,
    FormsModule, 
    SharedModule
  ],
  providers: [ReservaService]
})

export class ReservaModule { }
