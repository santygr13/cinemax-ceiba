var pelicula = require('./src/pages/pelicula');


describe('Pagina principal pelicula', function () {

    
    it('Crear pelicula',  function () {
        pelicula.goPelicula()
        pelicula.setNombre()
        pelicula.setNumeroSalaCine()
        pelicula.Sleep()
        pelicula.crear()
        pelicula.Sleep()
    })

    it('listar pelicula', function(){
        pelicula.goListaPelicula()
        pelicula.Sleep()
    })
})