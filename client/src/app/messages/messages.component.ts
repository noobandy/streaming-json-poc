import { Component, OnInit } from '@angular/core';
import {Message} from '../message'
import {MessageService} from '../message.service'

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  message: Message
  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.loadMessages()
  }

  loadMessages(): void {
    this.messageService.getMessages().subscribe({
      next: function(message: Message) {
        this.message = message
      }
    })
  }
}
