import { Component, OnInit } from '@angular/core'
import {INews} from "./model/news";
import {NewsProviderService} from "./services/news-provider.service";

@Component({
    templateUrl: 'app/newsProvider/news-list.component.html',
    styleUrls: ['app/app.component.css']
})

export class NewsListComponent implements OnInit {
    pageTitle: string = 'News';
    errorMessage: string;
    newsList: INews[];

    constructor(private _newProviderService: NewsProviderService) {}

    ngOnInit(): void {
        this._newProviderService.getAllNews()
            .subscribe(
                newsList => this.newsList = newsList,
                error => this.errorMessage = <any>error
            );
    }

}