import { Pelicula } from "./pelicula"
import { Principal } from './principal';
import { browser } from 'protractor';

describe('Pagina principal pelicula', function () {

    let pelicula: Pelicula;
    let principal: Principal;

    beforeEach(() => {
        pelicula = new Pelicula();
        principal = new Principal()
    })

    it('Crear pelicula', function () {
        principal.goPrincipal()
        pelicula.goPelicula()
        pelicula.setNombre('joker')
        pelicula.setNumeroSalaCine()
        browser.sleep(5000)
        pelicula.crearPelicula()
    })

    it('listar pelicula', function () {
        principal.goPrincipal()
        pelicula.goListaPelicula()
        browser.sleep(5000)
    })
    
})