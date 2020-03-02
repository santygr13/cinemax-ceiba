var principal = require('./src/pages/principal');


describe('Pagina principal', function(){

    
    it('Enlace, navegar pagina principal', function(){
        principal.goPrincipal()
        principal.Sleep()
        
    })
})