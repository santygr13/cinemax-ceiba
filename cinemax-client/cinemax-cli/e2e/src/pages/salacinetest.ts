import { SalaCine } from "./salacine";
import { Principal } from './principal';


describe('Pagina principal SalaCine', function () {


    let salacine: SalaCine;
    let principal: Principal;

    beforeEach(() => {
        salacine = new SalaCine();
        principal = new Principal()
    })

    it('Crear SalaCine', async function () {

        await principal.goPrincipal()
        salacine.goSalaCine()
        salacine.setNumeroSalaCine('1')
        salacine.setCapacidadSillas(20000)
        salacine.setEstadoSalaCine()
        await salacine.crearSalaCine()
        salacine.sweetAlert()
        expect(salacine.elementoTitle().getText()).toContain('Registro Exitoso')
    })

    

})