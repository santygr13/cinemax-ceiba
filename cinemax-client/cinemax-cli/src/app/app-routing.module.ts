import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [

  { path: '', redirectTo: 'principal', pathMatch: 'full' },
  { path: 'principal', loadChildren: () => import('./feature/principal/principal.module').then(m => m.PrincipalModule) },
  { path: 'pelicula', loadChildren: () => import('./feature/pelicula/pelicula.module').then(m => m.PeliculaModule) },
  { path: 'reserva', loadChildren: () => import('./feature/reserva/reserva.module').then(m => m.ReservaModule) },
  { path: 'salacine', loadChildren: () => import('./feature/salacine/salacine.module').then(m => m.SalacineModule) },
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
