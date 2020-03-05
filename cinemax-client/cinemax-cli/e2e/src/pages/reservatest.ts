import { Principal } from "./principal";
import { Reserva } from './reserva';
import { browser } from 'protractor';

describe('Pagina principal reserva', function () {

    let reserva: Reserva;
    let principal: Principal;

    beforeEach(() => {
        reserva = new Reserva;
        principal = new Principal()
    })

    it('Crear Reserva', async  function () {
        principal.goPrincipal()
        reserva.goReserva()
        reserva.setNombreCliente('santiago')
        reserva.setDocumentoCliente(10369263)
        reserva.setCantidadPuestos(5)
        reserva.setNombrePelicula()
        reserva.setFechaReservaPelicula('2020-03-27')
        reserva.crearReserva()
        

    })

    it('listar Reserva', function () {
        principal.goPrincipal()
        reserva.goListaReserva()
        browser.sleep(5000)
    })

})