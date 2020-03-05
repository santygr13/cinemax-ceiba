import { element, by } from 'protractor';

var pelicula = {
    nombre: element(by.id('inputnombre')),
    numeroSalaCine: element(by.id('listaOpciones'))
};
module.exports = {

    setNombre(name: string) {
        this.nombre.sendKeys(name);
    },

    setNumeroSalaCine: function () {
        this.numeroSalaCine.$('[value="0: 1"]').click()
    },

    delay(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    },

    Sleep: async function () {
        
        await this.delay(3000)
    },

    crear: function () {
        document.getElementById('crear').click();
    },

    goPelicula: function () {
        document.getElementById('crear-pelicula').click()
    },

    goListaPelicula: function () {
        document.getElementById('listar-pelicula').click()
    },

    



};
