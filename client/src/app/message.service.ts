import { Injectable } from '@angular/core';
import { Message } from './message';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: Message[] = []

  constructor() { }

  pushMessage(message: Message): void {
    this.messages.push(message)
  }

  getMessages(): Observable<Message> {
    return new Observable<Message>(subscriber => {
      setInterval(() => {
        while(this.messages.length > 0) {
          subscriber.next(this.messages.shift())
        }
      }, 100)
    })
  }
}
