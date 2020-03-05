import {
    HttpInterceptor,
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpHeaders
}from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class HeaderInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let headers = new HttpHeaders();

        if (request.method !== 'GET') {
            headers.append('Content-Type', 'application/json');
        }
        else {
            headers.append('Accept', 'application/json')
        }

        const modified = request.clone({
            headers: headers
        })

        console.log('Intercepted HTTP call', modified);

        return next.handle(modified);
    }
}