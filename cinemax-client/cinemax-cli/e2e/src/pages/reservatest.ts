import { Principal } from "./principal";
import { Reserva } from './reserva';


describe('Pagina principal reserva', function () {

    let reserva: Reserva;
    let principal: Principal;

    beforeEach(() => {
        reserva = new Reserva;
        principal = new Principal()
    })

    it('Crear Reserva', async function () {
        await principal.goPrincipal()
        await reserva.goReserva()
        reserva.setNombreCliente('santiago')
        reserva.setDocumentoCliente(10369263)
        reserva.setCantidadPuestos(5)
        reserva.setNombrePelicula()
        reserva.setFechaReservaPelicula('2020-03-27')
        await reserva.crearReserva()
        reserva.sweetAlert()
        expect(reserva.elementoTitle().getText()).toContain('Reserva Exitosa')

    })

    it('listar Reserva', async function () {
        await principal.goPrincipal()
        await reserva.goListaReserva()

    })

})