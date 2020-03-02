
var reserva = {
  fechaReservaPelicula: '2020-03-27',
  cantidadPuestos: 4,
  documentoCliente: 103677644,
  nombreCliente: 'santiago',
  nombrePelicula: 'perro'
};

module.exports = {

  goReserva: function () {
    browser.get('http://localhost:4200/reserva')

  },

  goListaReserva: function(){
    browser.get('http://localhost:4200/listaReserva')
  },

  Sleep: function () {
    browser.sleep(3000)
  },

  setFechaReservaPelicula: function () {
    element(by.id('inputFechaReservaPelicula')).sendKeys(reserva.fechaReservaPelicula);
  },

  setCantidadPuestos: function () {
    element(by.id('inputCantidadPuestos')).sendKeys(reserva.cantidadPuestos);
  },

  setDocumentoCliente: function () {
    element(by.id('inputDocumentoCliente')).sendKeys(reserva.documentoCliente);
  },

  setNombreCliente: function () {
    element(by.id('inputNombreCliente')).sendKeys(reserva.nombreCliente);
  },

  setNombrePelicula: function () {
    element(by.id('listaOpciones')).$('[value="0: perro"]').click();
  },


  crear: function () {
    element(by.buttonText('Crear')).click();
  }
}   