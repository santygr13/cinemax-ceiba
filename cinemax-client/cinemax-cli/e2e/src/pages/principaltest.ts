
import { Principal } from './principal';

describe('Navegar pagina principal', () => {
    let principal: Principal;

    beforeEach(() => {
        principal = new Principal();
    });

    it('Navegar pagina principal', function () {
        principal.goPrincipal()
    })


})