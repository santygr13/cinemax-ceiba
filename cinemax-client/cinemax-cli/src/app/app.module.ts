import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { PeliculaService } from './shared/services/pelicula.service';
import { SalacineService } from './shared/services/salacine.service';
import { HttpErrorInterceptor } from './http-error.interceptor';
import { CoreModule } from './core/core.module';



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
    CoreModule

  ],
  providers: [{provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
