import {Component, Inject} from '@angular/core';
import {NewsProviderService} from "./services/news-provider.service";

@Component({
    templateUrl: 'app/newsProvider/news-form.component.html'
})
export class NewsFormComponent {
    pageTitle: string = "Add News";
    title : string;
    body : string;
    author : string;
    publishDate : string;

    constructor(private _newProviderService: NewsProviderService) {}

    createNewNews() : void {
        var news = {
            newsId: '',
            title: this.title,
            body: this.body,
            author: this.author,
            publishDate: this.publishDate
        };

        this._newProviderService.createNews(news)
            .subscribe(
                news => {
                    if(news) {
                        console.log('News created');
                        this.title = '';
                        this.body = '';
                        this.author = '';
                        this.publishDate = '';
                        alert('News successfully added');
                    }
                }
            )
    }
}