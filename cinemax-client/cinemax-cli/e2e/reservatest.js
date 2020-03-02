var reserva = require('./src/pages/reserva');


describe('Pagina Reserva', function(){

    it('Crear reserva' , function(){

        reserva.goReserva()
        reserva.setCantidadPuestos()
        reserva.setDocumentoCliente()
        reserva.setFechaReservaPelicula()
        reserva.setNombreCliente()
        reserva.setNombrePelicula()
        reserva.Sleep()
        reserva.crear()
        reserva.Sleep()
    })

    it('listar reserva', function(){
        reserva.goListaReserva()
        reserva.Sleep()
    })
})