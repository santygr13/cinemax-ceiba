import { element, by, protractor, browser } from 'protractor';

var EC = protractor.ExpectedConditions;
export class SalaCine {

    salacine = {
        numeroSalaCine: element(by.id('inputnumeroSalaCine')),
        capacidadSillas: element(by.id('inputcapacidadsillas')),
        estadoSalaCine: element(by.id('listaOpciones')),

    }


    setNumeroSalaCine(numeroSalaCine: string) {
        this.salacine.numeroSalaCine.sendKeys(numeroSalaCine)
    }

    setCapacidadSillas(capacidadSillas: number) {
        this.salacine.capacidadSillas.sendKeys(capacidadSillas)
    }

    setEstadoSalaCine() {
        this.salacine.estadoSalaCine.$('[value=true]').click();
    }

    goSalaCine() {

        return element(by.id('crear-salacine')).click();

    }

    crearSalaCine() {
        return element(by.buttonText('Crear')).click();

    }

    elementoTitle(){
        return element(by.id('swal2-title'))
    }

    sweetAlert() {
        browser.wait(EC.presenceOf(element(by.id('swal2-title'))))
    }
    

}