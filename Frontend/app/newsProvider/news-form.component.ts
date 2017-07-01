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

    constructor(private _newProviderService: NewsProviderService) {}

    createNewNews() : void {
        var news = {
            _id: '',
            title: this.title,
            body: this.body,
            author: this.author
        };

        this._newProviderService.createNews(news)
            .subscribe(
                news => {
                    if(news) {
                        console.log('News created');
                    }
                }
            )
    }
}