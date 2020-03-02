import {
    HttpEvent,
    HttpInterceptor,
    HttpHandler,
    HttpRequest,
    HttpErrorResponse,
    HttpHeaders,

} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';


export class HttpErrorInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let headers = new HttpHeaders();

        if (request.method !== 'GET') {
            headers.append('Content-Type', 'application/json');
        }
        
        
        const modified= request.clone({
           headers:headers
        })

        return next.handle(modified)
            .pipe(
                retry(1),
                catchError((error: HttpErrorResponse) => {
                    let errorMessage = '';
                    if (error.error instanceof ErrorEvent) {
                        // client-side error
                        errorMessage = `Error: ${error.error.message}`;
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Oops... Verifica de nuevo los datos ingresados',
                            text: errorMessage,
                            showConfirmButton: true
                        });

                    } else {
                        // server-side error
                        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
                    }

                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Oops... Error del servidor',
                        text: errorMessage,
                        showConfirmButton: true
                    });
                    return throwError(errorMessage);
                })
            )
    }
}