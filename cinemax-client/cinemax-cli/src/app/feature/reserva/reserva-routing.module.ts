import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearReservaComponent } from './components/crear-reserva/crear-reserva.component';
import { ListarReservaComponent } from './components/listar-reserva/listar-reserva.component';


const routes: Routes = [
  { path: '', component: CrearReservaComponent },
  { path: 'listaReserva', component: ListarReservaComponent }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReservaRoutingModule { }
