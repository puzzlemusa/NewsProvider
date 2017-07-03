import { Component, OnInit } from '@angular/core'
import {INews} from "./model/news";
import {NewsProviderService} from "./services/news-provider.service";
import {ConfigService} from "./services/config";

@Component({
    templateUrl: 'app/newsProvider/news-list.component.html',
    styleUrls: ['app/app.component.css']
})

export class NewsListComponent implements OnInit {
    pageTitle: string = 'News Collection';
    errorMessage: string;
    newsList: INews[];
    apiUrl: string;

    constructor(private _newProviderService: NewsProviderService,
                private _configService : ConfigService) {}

    ngOnInit(): void {
        this._newProviderService.getAllNews()
            .subscribe(
                newsList => this.newsList = newsList,
                error => this.errorMessage = <any>error
            );

        this.apiUrl = this._configService.get("apiUrl");
    }

}