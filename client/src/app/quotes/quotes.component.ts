import { Component, OnInit } from '@angular/core';
import {Quote} from '../../quote'
import { QuoteService } from '../quote.service';

@Component({
  selector: 'app-quotes',
  templateUrl: './quotes.component.html',
  styleUrls: ['./quotes.component.css']
})
export class QuotesComponent implements OnInit {

  quotes: Quote[] = []

  constructor(private quoteService: QuoteService) { }

  ngOnInit() {
    this.getQuotes()
  }


  getQuotes(): void {
    this.quoteService.getQuotes().subscribe((quote) => {
      this.quotes.push(quote)
    }, (e) => {
      console.log(e)
    }, () => {
      console.log('completed')
    })
  }
}
