import { Pelicula } from "./pelicula"
import { Principal } from './principal';


describe('Pagina principal pelicula', function () {

    let pelicula: Pelicula;
    let principal: Principal;

    beforeEach(() => {
        pelicula = new Pelicula();
        principal = new Principal()
    })

    it('Crear pelicula', async function () {
        await principal.goPrincipal()
        await pelicula.goPelicula()
        pelicula.setNombre('joker')
        pelicula.setNumeroSalaCine()
        await pelicula.crearPelicula()
        pelicula.sweetAlert()
        expect(pelicula.elementoTitle().getText()).toContain('Registro Exitoso')
    })

    it('listar pelicula', async function () {
        await principal.goPrincipal()
        await pelicula.goListaPelicula()

    })

})