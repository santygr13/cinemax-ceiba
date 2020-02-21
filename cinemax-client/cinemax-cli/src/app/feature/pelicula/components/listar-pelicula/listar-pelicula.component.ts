import { OnInit, Component } from '@angular/core';
import { PeliculaService } from '../../shared/services/pelicula.service';
import { Pelicula } from '../../shared/model/pelicula';




@Component({
    selector: 'app-listar-pelicula',
    templateUrl: './listar-pelicula.component.html',
    styleUrls: ['./listar-pelicula.component.css']
})
export class ListarPeliculaComponent implements OnInit {


    pelicula: Pelicula[]


    constructor(private peliculaService: PeliculaService) {

    }


    ngOnInit() {

        this.getPeliculas();

    }
    getPeliculas() {
        this.peliculaService.getPeliculas().subscribe((data: any) => {
            this.pelicula = data;
        });
    }


}