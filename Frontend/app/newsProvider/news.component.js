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
var router_1 = require("@angular/router");
var NewsComponent = (function () {
    function NewsComponent(_router, _route, _newProviderService) {
        this._router = _router;
        this._route = _route;
        this._newProviderService = _newProviderService;
        this.pageTitle = 'News';
    }
    NewsComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (!this.news) {
            this._route.params.subscribe(function (params) {
                _this.newsId = params['newsId'];
            });
        }
        this._newProviderService.getNews(this.newsId)
            .subscribe(function (news) {
            _this.news = news;
            _this.pageTitle = _this.news.title;
        }, function (error) { return _this.errorMessage = error; });
    };
    NewsComponent.prototype.onBack = function () {
        this._router.navigate(['viewnews']);
    };
    NewsComponent = __decorate([
        core_1.Component({
            templateUrl: 'app/newsProvider/news.component.html',
        }),
        __metadata("design:paramtypes", [router_1.Router,
            router_1.ActivatedRoute,
            news_provider_service_1.NewsProviderService])
    ], NewsComponent);
    return NewsComponent;
}());
exports.NewsComponent = NewsComponent;
//# sourceMappingURL=news.component.js.map