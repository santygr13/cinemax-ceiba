import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrincipalComponent } from './components/principal.component';


const routes: Routes = [
  { path: 'principal', component: PrincipalComponent },
  { path: '', redirectTo: 'principal', pathMatch: 'full' },

];



@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrincipalRoutingModule { }
