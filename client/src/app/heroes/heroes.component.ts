import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import {HeroService} from "../hero.service"
import {Message} from '../message'
import {MessageService} from '../message.service'

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[] = []
  constructor(private heroService: HeroService, private messageService: MessageService) { }

  ngOnInit() {
    this.getHeroes()
  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe(heroes => {
      this.heroes = heroes
      this.messageService.pushMessage({
        id: 1,
        message: "Loaded Heroes"
      })
    })
  }

}
