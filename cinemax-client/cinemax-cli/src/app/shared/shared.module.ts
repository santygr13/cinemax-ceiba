import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header/header.component';
import { FooterComponent } from './footer/footer/footer.component';
import { PeliculaService } from './services/pelicula.service';
import { SalacineService } from './services/salacine.service';






@NgModule({
  declarations: [HeaderComponent, FooterComponent],
  imports: [
    CommonModule
  ],
  exports: [HeaderComponent,FooterComponent],
  providers: [PeliculaService,SalacineService]
  
})
export class SharedModule {}
