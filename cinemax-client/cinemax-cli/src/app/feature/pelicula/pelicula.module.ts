import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PeliculaRoutingModule } from './pelicula-routing.module';
import { CrearPeliculaComponent } from './components/crear-pelicula/crear-pelicula.component';
import { FormsModule } from '@angular/forms';
import { ListarPeliculaComponent } from './components/listar-pelicula/listar-pelicula.component';
import { SharedModule } from 'src/app/shared/shared.module';




@NgModule({
  declarations: [
    CrearPeliculaComponent,
    ListarPeliculaComponent
  ],

  imports: [
    CommonModule,
    PeliculaRoutingModule,
    FormsModule,
    SharedModule
  ],
 
})
export class PeliculaModule { }
