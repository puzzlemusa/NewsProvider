import {Injectable} from '@angular/core'
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {INews} from "../model/news";
import {ConfigService} from "./config";

@Injectable()
export class NewsProviderService {
    private apiUrl: string;

    constructor(private _http: Http,
                private _config: ConfigService) {
    }

    getAllNews(): Observable<INews[]> {
        this.getApiUrl();
        return this._http.get(this.apiUrl + '.json')
            .map((response: Response) => response.json())
            .do(data => console.log('ALL: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    getNews(newsId: string): Observable<INews> {
        this.getApiUrl();
        return this._http.get(this.apiUrl  + '/' + newsId + '.json')
            .map((response: Response) => response.json())
            .do(data => console.log('News: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    createNews(news: INews) : Observable<INews> {
        this.getApiUrl();
        delete news['newsId'];
        let bodyString = JSON.stringify(news);
        let headers      = new Headers({ 'Content-Type': 'application/json' });
        let options       = new RequestOptions({ headers: headers });

        return this._http.post(this.apiUrl + '.json', bodyString, options)
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

    private getApiUrl(){
        if(!this.apiUrl)
            this.apiUrl = this._config.get("apiUrl");
    }
}