import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearsalacineComponent } from './components/crearsalacine/crearsalacine.component';


const routes: Routes = [
  {path:'salacine',component:CrearsalacineComponent}
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalacineRoutingModule { }
