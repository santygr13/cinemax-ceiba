import { browser, by, element } from 'protractor';

export class Principal {


    goPrincipal() {
        return browser.get(browser.baseUrl);
    }

}
