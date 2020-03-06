import { browser } from 'protractor';

export class Principal {


    goPrincipal() {
        return browser.get(browser.baseUrl);
    }

}
