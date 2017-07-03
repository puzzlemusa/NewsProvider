import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ConfigService {
    private _config: Object;

    constructor(private _http: Http) { }

    load() {
        this._http.get("app/config/configuration.json")
            .map(res => res.json())
            .catch((error: any) => {
                console.error(error);
                return Observable.throw(error.json().error || "Server error");
            })
            .subscribe((data) => {
                this._config = data;
            });
    }

    get(key: any) {
        return this._config[key];
    }
}