import { element, by } from 'protractor';

export class Reserva {

    reserva = {
        fechaReservaPelicula: element(by.id('inputFechaReservaPelicula')),
        cantidadPuestos: element(by.id('inputCantidadPuestos')),
        documentoCliente: element(by.id('inputDocumentoCliente')),
        nombreCliente: element(by.id('inputNombreCliente')),
        nombrePelicula: element(by.id('listaOpciones'))
    }

    setFechaReservaPelicula(fechaReservaPelicula: string) {
        this.reserva.fechaReservaPelicula.sendKeys(fechaReservaPelicula);
    }

    setCantidadPuestos(cantidadPuestos: number) {
        this.reserva.cantidadPuestos.sendKeys(cantidadPuestos);
    }

    setDocumentoCliente(documentoCliente: number) {
        this.reserva.documentoCliente.sendKeys(documentoCliente);
    }

    setNombreCliente(nombreCliente: string) {
        this.reserva.nombreCliente.sendKeys(nombreCliente);
    }

    setNombrePelicula() {
        this.reserva.nombrePelicula.$('[value="0: joker"]').click();
    }

    crearReserva() {
        element(by.buttonText('Crear')).click();
    }

    goReserva() {
        element(by.id('crear-reserva')).click()
    }

    goListaReserva() {
        element(by.id('listar-reserva')).click()
    }

}