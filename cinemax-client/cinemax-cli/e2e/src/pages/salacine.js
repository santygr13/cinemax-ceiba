
var salacine = {
    numeroSalaCine: '1',
    capacidadSillas: 20000000,
    estadoSalaCine: true
};



module.exports = {

    setNumeroSalaCine: function () {
        element(by.id('inputnumeroSalaCine')).sendKeys(salacine.numeroSalaCine);
    },

    setCapacidadSillas: function () {
        element(by.id('inputcapacidadsillas')).sendKeys(salacine.capacidadSillas);
    },

    setEstadoSalaCine: function () {
        element(by.id('listaOpciones')).$('[value="true"]').click();
    },

    btnCrearSalaCine: function () {
        element(by.id('btnCrearSalaCine')).click();
    },

    crear: function () {
        element(by.buttonText('Crear')).click();
    },

    goSalaCine: function () {
        browser.get('http://localhost:4200/salacine')
    },

    Sleep: function () {
        browser.sleep(3000)
    },

    menuSalaCineClick: function () {
        element(by.id('crear-salacine')).click();
    },

    sweetAlert: function () {
        element(by.className("swal2-html-container"));
    }

}


