import { element, by } from 'protractor';


export class SalaCine {

    salacine = {
        numeroSalaCine: element(by.id('inputnumeroSalaCine')),
        capacidadSillas:  element(by.id('inputcapacidadsillas')),
        estadoSalaCine: element(by.id('listaOpciones'))
    }

    setNumeroSalaCine(numeroSalaCine: string) {
        this.salacine.numeroSalaCine.sendKeys(numeroSalaCine)
    }

    setCapacidadSillas(capacidadSillas : number){
        this.salacine.capacidadSillas.sendKeys(capacidadSillas)
    }
    
    setEstadoSalaCine(){
        this.salacine.estadoSalaCine.$('[value=true]').click();
    }

    goSalaCine(){

        element(by.id('crear-salacine')).click()
       
    }

    crearSalaCine(){
        element(by.buttonText('Crear')).click();
    }
}