import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { PeliculaService } from './shared/services/pelicula.service';
import { SalacineService } from './shared/services/salacine.service';



@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    SharedModule

  ],
  providers: [PeliculaService,SalacineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
