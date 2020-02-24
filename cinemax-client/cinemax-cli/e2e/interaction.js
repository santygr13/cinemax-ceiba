'use strict'

describe('CineMaxApp interaction', function () {

    var pelicula = {
        nombre: 'perro',
        numeroSalaCine: '1'
    };

    var reserva = {
        fechaReservaPelicula: '27/02/2020',
        cantidadPuestos: 20,
        documentoCliente: 103677644,
        nombreCliente: 'santiago',
        nombrePelicula: 'perro'
    };

    var salacine = {
        numeroSalaCine: '1',
        capacidadSillas: 200,
        estadoSalaCine: true
    };


    it('Enlace, navegar pagina principal', function () {
        browser.get('http://localhost:4200/#/principal');
        expect(browser.getTitle()).toEqual('Cinemax');
        browser.sleep(4000);
    });


    it('Enlace, crear salacine', function () {
        browser.get('http://localhost:4200/#/principal');
        element(by.id('crear-salacine')).click();
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/salacine');
        browser.sleep(1000);
    });


    it('Crear SalaCine', function () {
        browser.get('http://localhost:4200/#/salacine');
        element(by.id('inputnumeroSalaCine')).sendKeys(salacine.numeroSalaCine);
        element(by.id('inputcapacidadsillas')).sendKeys(salacine.capacidadSillas);
        element(by.id('listaOpciones')).$('[value="true"]').click();
        browser.sleep(1000);
        element(by.id('btnCrearSalaCine')).click();
        element(by.buttonText('Crear')).click();
    });


    it('Volver del form de crear salaCine a la pag principal', function () {
        browser.get('http://localhost:4200/#/salacine');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/principal');
        browser.sleep(1000);

    });

    it('Enlace, crear pelicula', function () {
        browser.get('http://localhost:4200/#/principal');
        element(by.id('crear-pelicula')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/pelicula');
        browser.sleep(1000);
    });



    it('Crear pelicula', function () {

        browser.get('http://localhost:4200/#/salacine');
        element(by.id('inputnumeroSalaCine')).sendKeys(salacine.numeroSalaCine);
        element(by.id('inputcapacidadsillas')).sendKeys(salacine.capacidadSillas);
        element(by.id('listaOpciones')).$('[value="true"]').click();
        browser.sleep(1000);
        element(by.id('btnCrearSalaCine')).click();
        element(by.buttonText('Crear')).click();

        browser.get('http://localhost:4200/#/pelicula');
        element(by.id('inputnombre')).sendKeys(pelicula.nombre);
        element(by.id('listaOpciones')).$('[value="1"]').click();
        browser.sleep(1000000);
        element(by.id('btnCrearPelicula')).click();
        element(by.buttonText('Crear')).click();
        

    });

    it('Volver del form de crear pelicula a la pag principal', function () {
        browser.get('http://localhost:4200/#/pelicula');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/principal');
        browser.sleep(1000);

    });

/*
    it('Enlace, crear reserva', function () {
        browser.get('http://localhost:4200/#/principal');
        element(by.id('crear-reserva')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/reserva');
        browser.sleep(1000);
    });

    it('Crear Reserva', function () {
        browser.get('http://localhost:4200/#/reserva');
        element(by.id('inputDocumentoCliente')).sendKeys(reserva.documentoCliente);
        element(by.id('inputNombreCliente')).sendKeys(reserva.nombreCliente);
        element(by.id('inputCantidadPuestos')).sendKeys(reserva.cantidadPuestos);
        element(by.id('listaOpciones')).sendKeys(reserva.nombrePelicula);
        element(by.id('inputFechaReservaPelicula')).sendKeys(reserva.fechaReservaPelicula);

        browser.sleep(1000);
        element(by.id('btnCrearReserva')).click();
        element(by.buttonText('OK')).click();

    });

    it('Volver del form de crear reserva a la pag principal', function () {
        browser.get('http://localhost:4200/reserva');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/principal');
        browser.sleep(1000);

    });


    it('Enlace, listar pelicula', function () {
        browser.get('http://localhost:4200/#/principal');
        element(by.id('listar-pelicula')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/listaPelicula');
        browser.sleep(1000);
    });

    it('Volver del form de listar pelicula a la pag principal', function () {
        browser.get('http://localhost:4200/#/listaReserva');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/principal');
        browser.sleep(1000);

    });


    it('Enlace, listar reserva', function () {
        browser.get('http://localhost:4200/#/principal');
        element(by.id('listar-reserva')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/listaReserva');
        browser.sleep(1000);
    });

    it('Volver del form de listar reserva a la pag principal', function () {
        browser.get('http://localhost:4200/#/listaReserva');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/#/principal');
        browser.sleep(1000);

    });
*/
})