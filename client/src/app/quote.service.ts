import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Quote } from 'src/quote';
import { Observable } from 'rxjs';
import * as oboe from 'oboe'

@Injectable({
  providedIn: 'root'
})
export class QuoteService {

  constructor(private httpClient: HttpClient) { }

  getQuotes(): Observable<Quote> {
    return new Observable(client => {
      oboe(`${location.protocol}//${location.host}/api/rq/quotes/aMillionQuotes`).node("![*]", quote => {
        client.next(quote)
      }).done(()=> {
        client.complete()
      }).fail((err) => {
        client.error(err)
      })
    })
  }
}
