import { element, by, protractor, browser } from 'protractor';

var EC = protractor.ExpectedConditions;
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
        return element(by.buttonText('Crear')).click();
    }

    goReserva() {
        return element(by.id('crear-reserva')).click()
    }

    goListaReserva() {
       return element(by.id('listar-reserva')).click()
    }

    elementoTitle(){
        return element(by.id('swal2-title'))
    }

    sweetAlert() {
        browser.wait(EC.presenceOf(element(by.id('swal2-title'))))
    }
    
}