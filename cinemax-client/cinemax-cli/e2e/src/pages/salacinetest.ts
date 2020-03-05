import { SalaCine } from "./salacine";
import { Principal } from './principal';
import { browser } from 'protractor';

describe('Pagina principal SalaCine', function () {


    let salacine: SalaCine;
    let principal: Principal;

    beforeEach(() => {
        salacine = new SalaCine();
        principal= new Principal()
    })

    it('Crear SalaCine',  function () {
        
        principal.goPrincipal()
        salacine.goSalaCine()
        salacine.setNumeroSalaCine('1')
        salacine.setCapacidadSillas(20000)
        salacine.setEstadoSalaCine()
        browser.sleep(5000)
        salacine.crearSalaCine()
       
    })


})