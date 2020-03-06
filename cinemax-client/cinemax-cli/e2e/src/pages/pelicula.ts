import { element, by, browser, protractor } from 'protractor';

var EC = protractor.ExpectedConditions;
export class Pelicula {

    pelicula = {
        nombre: element(by.id('inputnombre')),
        numeroSalaCine: element(by.id('listaOpciones'))
    }

    setNombre(name: string) {
        this.pelicula.nombre.sendKeys(name);
    }

    setNumeroSalaCine() {
        this.pelicula.numeroSalaCine.$('[value="0: 1"]').click()
    }

    goPelicula() {

        return element(by.id('crear-pelicula')).click()
    }

    crearPelicula() {
        return element(by.buttonText('Crear')).click();
    }

    goListaPelicula() {
        return element(by.id('listar-pelicula')).click()
    }


    elementoTitle() {
        return element(by.id('swal2-title'))
    }

    sweetAlert() {
        browser.wait(EC.presenceOf(element(by.id('swal2-title'))))
    }
}
