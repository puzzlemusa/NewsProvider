import {APP_INITIALIZER, NgModule}      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http'
import { RouterModule, Routes} from '@angular/router'

import { AppComponent }   from './app.component';
import { NewsFormComponent } from './newsProvider/news-form.component'
import {NewsProviderService} from "./newsProvider/services/news-provider.service";
import {NewsListComponent} from "./newsProvider/news-list.component";
import {NewsComponent} from "./newsProvider/news.component";
import {ConfigService} from "./newsProvider/services/config";

const appRoutes: Routes = [
    { path: '', redirectTo: 'addnews', pathMatch: 'full' },
    { path: 'addnews', component: NewsFormComponent },
    { path: 'viewnews', component: NewsListComponent },
    { path: 'viewnews/:newsId', component: NewsComponent}
    //{ path: '**', component: PageNotFoundComponent }
];

function loadConfig(context: ConfigService) {
    return () => context.load();
}

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(appRoutes)
    ],
    declarations: [
        AppComponent,
        NewsFormComponent,
        NewsListComponent,
        NewsComponent
    ],
    providers: [
        NewsProviderService,
        ConfigService,
        { provide: APP_INITIALIZER,
            useFactory: loadConfig,
            deps: [ConfigService],
            multi: true }
    ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }