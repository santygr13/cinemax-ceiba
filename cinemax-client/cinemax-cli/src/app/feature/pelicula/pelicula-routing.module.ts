import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearPeliculaComponent } from './components/crear-pelicula/crear-pelicula.component';
import { ListarPeliculaComponent } from './components/listar-pelicula/listar-pelicula.component';


const routes: Routes = [
  { path: '', component: CrearPeliculaComponent },
  { path: 'listaPelicula', component: ListarPeliculaComponent }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PeliculaRoutingModule { }
