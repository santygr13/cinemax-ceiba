import { element, by } from 'protractor';

export class Pelicula {

    pelicula = {
        nombre: element(by.id('inputnombre')),
        numeroSalaCine: element(by.id('listaOpciones'))
    }

    setNombre(name: string) {
        this.pelicula.nombre.sendKeys(name);
    }

    setNumeroSalaCine(){
        this.pelicula.numeroSalaCine.$('[value="0: 1"]').click()
    }

    goPelicula(){

        element(by.id('crear-pelicula')).click()
    }
    
    crearPelicula(){
        element(by.buttonText('Crear')).click();
    }

    goListaPelicula(){
        element(by.id('listar-pelicula')).click() 
    }
}
