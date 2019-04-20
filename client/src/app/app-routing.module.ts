import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HeroesComponent } from '../app/heroes/heroes.component'
import {DashboardComponent} from '../app/dashboard/dashboard.component'
import {HeroDetailComponent} from '../app/hero-detail/hero-detail.component'
import { QuotesComponent } from './quotes/quotes.component';

const routes: Routes = [{
  path: 'heroes',
  component: HeroesComponent
}, {
  path: 'dashboard',
  component: DashboardComponent
}, {
  path: 'detail/:id',
  component: HeroDetailComponent
}, {
  path: 'quotes',
  component: QuotesComponent
}, {
  path: '',
  redirectTo: 'dashboard',
  pathMatch: 'full'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
