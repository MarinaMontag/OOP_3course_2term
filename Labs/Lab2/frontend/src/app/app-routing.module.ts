import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ProfileComponent} from './profile/profile.component';
import {TestListComponent} from './test-list/test-list.component';
import {PassTestComponent} from './pass-test/pass-test.component';
import {AuthGuard} from './_guards/auth.guard';
import {CreateTestComponent} from './create-test/create-test.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {path:  'subject/:id', component: TestListComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'test/:id', component: PassTestComponent, canActivate: [AuthGuard] },
  { path: 'create/:id', component: CreateTestComponent, canActivate: [AuthGuard]},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
