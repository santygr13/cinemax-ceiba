var salacine = require('./src/pages/salacine');

describe('Pricipal Sala Cine', function () {

    
    it('Crear Sala Cine', function () {

        salacine.goSalaCine()
        salacine.setNumeroSalaCine()
        salacine.setCapacidadSillas()
        salacine.setEstadoSalaCine()
        salacine.Sleep()
        salacine.crear()
        salacine.Sleep()
    })
    

})