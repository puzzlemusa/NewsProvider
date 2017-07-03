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
var news_provider_service_1 = require("./services/news-provider.service");
var config_1 = require("./services/config");
var NewsListComponent = (function () {
    function NewsListComponent(_newProviderService, _configService) {
        this._newProviderService = _newProviderService;
        this._configService = _configService;
        this.pageTitle = 'News Collection';
    }
    NewsListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._newProviderService.getAllNews()
            .subscribe(function (newsList) { return _this.newsList = newsList; }, function (error) { return _this.errorMessage = error; });
        this.apiUrl = this._configService.get("apiUrl");
    };
    NewsListComponent = __decorate([
        core_1.Component({
            templateUrl: 'app/newsProvider/news-list.component.html',
            styleUrls: ['app/app.component.css']
        }),
        __metadata("design:paramtypes", [news_provider_service_1.NewsProviderService,
            config_1.ConfigService])
    ], NewsListComponent);
    return NewsListComponent;
}());
exports.NewsListComponent = NewsListComponent;
//# sourceMappingURL=news-list.component.js.map