import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [

  { path: '', loadChildren: () => import('./feature/principal/principal.module').then(m => m.PrincipalModule) },
  { path: '', loadChildren: () => import('./feature/pelicula/pelicula.module').then(m => m.PeliculaModule) },
  { path: '', loadChildren: () => import('./feature/reserva/reserva.module').then(m => m.ReservaModule) },
  { path: '', loadChildren: () => import('./feature/salacine/salacine.module').then(m => m.SalacineModule) },
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
