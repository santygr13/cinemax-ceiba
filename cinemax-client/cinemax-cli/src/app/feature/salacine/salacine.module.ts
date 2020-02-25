import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SalacineRoutingModule } from './salacine-routing.module';
import { CrearsalacineComponent } from './components/crearsalacine/crearsalacine.component';
import { SalacineService } from './shared/services/salacine.service';
import { FormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    CrearsalacineComponent
  ],
  imports: [
    CommonModule,
    SalacineRoutingModule,
    FormsModule,
    SharedModule
  ],
  providers: [SalacineService]
})
export class SalacineModule { }
