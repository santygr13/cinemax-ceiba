import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PeliculaService } from './services/pelicula.service';
import { SalacineService } from './services/salacine.service';






@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [PeliculaService,SalacineService]
  
})
export class SharedModule {}
