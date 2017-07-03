"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var router_1 = require("@angular/router");
var app_component_1 = require("./app.component");
var news_form_component_1 = require("./newsProvider/news-form.component");
var news_provider_service_1 = require("./newsProvider/services/news-provider.service");
var news_list_component_1 = require("./newsProvider/news-list.component");
var news_component_1 = require("./newsProvider/news.component");
var config_1 = require("./newsProvider/services/config");
var appRoutes = [
    { path: '', redirectTo: 'addnews', pathMatch: 'full' },
    { path: 'addnews', component: news_form_component_1.NewsFormComponent },
    { path: 'viewnews', component: news_list_component_1.NewsListComponent },
    { path: 'viewnews/:newsId', component: news_component_1.NewsComponent }
    //{ path: '**', component: PageNotFoundComponent }
];
function loadConfig(context) {
    return function () { return context.load(); };
}
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                http_1.HttpModule,
                router_1.RouterModule.forRoot(appRoutes)
            ],
            declarations: [
                app_component_1.AppComponent,
                news_form_component_1.NewsFormComponent,
                news_list_component_1.NewsListComponent,
                news_component_1.NewsComponent
            ],
            providers: [
                news_provider_service_1.NewsProviderService,
                config_1.ConfigService,
                { provide: core_1.APP_INITIALIZER,
                    useFactory: loadConfig,
                    deps: [config_1.ConfigService],
                    multi: true }
            ],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map