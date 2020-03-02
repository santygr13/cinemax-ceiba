

var pelicula = {
    nombre: 'perro',
    numeroSalaCine: '1'
};
module.exports = {



    setNombre: function () {
        element(by.id('inputnombre')).sendKeys(pelicula.nombre);
    },

    setNumeroSalaCine: function () {
        element(by.id('listaOpciones')).$('[value="0: 1"]').click();
    },

    crear: function () {
        element(by.buttonText('Crear')).click();
    },

    goPelicula: function () {
        browser.get('http://localhost:4200/pelicula');

    },
    goListaPelicula: function () {
        browser.get('http://localhost:4200/listaPelicula')
    },

    Sleep: function () {
        browser.sleep(3000)
    }

};
