import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';




export class BaseService {

    constructor(protected http: HttpClient) { }


    protected doPost<T, R>(serviceUrl: string, body: T) {

        return this.http.post(serviceUrl, body).pipe(
            map(response => response as R)
        )
    }

    protected doGet<T>(serviceUrl: string) {

        return this.http.get(serviceUrl).pipe(
            map(response => response as T)
        );
    }


}