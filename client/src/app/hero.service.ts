import { Injectable } from '@angular/core';
import {HEROES} from '../app/mock-heroes'
import {Hero} from '../app/hero'
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  constructor() { }

  getHeroes(): Observable<Hero[]> {
    return of(HEROES)
  }

  getHero(id: number): Observable<Hero> {
    return of(HEROES.find(hero => hero.id == id))
  }

}
