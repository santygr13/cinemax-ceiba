import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';


@NgModule({
    declarations: [HeaderComponent,FooterComponent],
    imports: [
      CommonModule
    ],

    exports:[HeaderComponent,FooterComponent]
     
  })
  export class CoreModule {}