import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http'
import { RouterModule, Routes} from '@angular/router'

import { AppComponent }   from './app.component';
import { NewsFormComponent } from './newsProvider/news-form.component'
import {NewsProviderService} from "./newsProvider/services/news-provider.service";

const appRoutes: Routes = [
    { path: '', redirectTo: 'addnews', pathMatch: 'full' },
    { path: 'addnews', component: NewsFormComponent },
    //{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(appRoutes)
    ],
    declarations: [
        AppComponent,
        NewsFormComponent
    ],
    providers: [
        NewsProviderService
    ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }