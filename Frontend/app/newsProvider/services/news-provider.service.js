"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var Observable_1 = require("rxjs/Observable");
var NewsProviderService = (function () {
    function NewsProviderService(_http) {
        this._http = _http;
        this.apiUrl = 'http://localhost:8080/news/';
    }
    NewsProviderService.prototype.getAllNews = function () {
        return this._http.get(this.apiUrl)
            .map(function (response) { return response.json(); })
            .do(function (data) { return console.log('ALL: ' + JSON.stringify(data)); })
            .catch(this.handleError);
    };
    NewsProviderService.prototype.createNews = function (news) {
        delete news['_id'];
        var bodyString = JSON.stringify(news);
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this._http.post(this.apiUrl, bodyString, options)
            .map(function (response) {
            if (response.status === 201) {
                return response.json();
            }
        })
            .catch(this.handleError);
    };
    NewsProviderService.prototype.handleError = function (error) {
        // in a real world app, we may send the server to some remote logging infrastructure
        // instead of just logging it to the console
        console.error(error);
        return Observable_1.Observable.throw(error.json().error || 'Server error: ' + error);
    };
    NewsProviderService = __decorate([
        core_1.Injectable(),
        __metadata("design:paramtypes", [http_1.Http])
    ], NewsProviderService);
    return NewsProviderService;
}());
exports.NewsProviderService = NewsProviderService;
//# sourceMappingURL=news-provider.service.js.map