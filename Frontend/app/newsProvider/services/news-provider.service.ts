import {Inject, Injectable} from '@angular/core'
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {INews} from "../model/news";

@Injectable()
export class NewsProviderService {
    private apiUrl = 'http://localhost:8080/news/';

    constructor(@Inject(Http)private _http: Http) { }

    getAllNews(): Observable<INews[]> {
        return this._http.get(this.apiUrl)
            .map((response: Response) => response.json())
            .do(data => console.log('ALL: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    createNews(news: INews) : Observable<INews> {
        delete news['_id'];
        let bodyString = JSON.stringify(news);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options       = new RequestOptions({ headers: headers });

        return this._http.post(this.apiUrl, bodyString, options)
            .map((response: Response) => {
                if(response.status === 201) {
                    return response.json();
                }
            })
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        // in a real world app, we may send the server to some remote logging infrastructure
        // instead of just logging it to the console
        console.error(error);
        return Observable.throw(error.json().error || 'Server error: ' + error);
    }
}