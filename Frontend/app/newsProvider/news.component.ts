import { Component, OnInit } from '@angular/core'
import {INews} from "./model/news";
import {NewsProviderService} from "./services/news-provider.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    templateUrl: 'app/newsProvider/news.component.html',
})

export class NewsComponent implements OnInit {
    pageTitle: string = 'News';
    errorMessage: string;
    newsId: string;
    news: INews;

    constructor(private _router: Router,
                private _route: ActivatedRoute,
                private _newProviderService: NewsProviderService) {}

    ngOnInit(): void {
        if(!this.news){
            this._route.params.subscribe(params => {
                this.newsId = params['newsId'];
            });
        }

        this._newProviderService.getNews(this.newsId)
            .subscribe(
                news => {
                    this.news = news;
                    this.pageTitle = this.news.title;
                },
                error => this.errorMessage = <any>error
            );
    }

    onBack(): void{
        this._router.navigate(['viewnews']);
    }

}