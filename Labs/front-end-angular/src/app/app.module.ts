import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import {RouterModule} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { TestListComponent } from './test-list/test-list.component';
import { SubBoardComponent } from './sub-board/sub-board.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthService} from './auth.service';
import {LoggingHttpInterceptor} from './logging-http.interceptor';
import {IronHttpInterceptor} from './iron/iron-http-interceptor';

const routes = [
  {path: '', redirectTo: '/subject', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'subject', component: SubBoardComponent},
  {path: 'tests', component: TestListComponent}
];

const interceptors = [
  {provide: HTTP_INTERCEPTORS, useClass: LoggingHttpInterceptor, multi: true},
  {provide: HTTP_INTERCEPTORS, useClass: IronHttpInterceptor, multi: true}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    TestListComponent,
    SubBoardComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService, interceptors],
  bootstrap: [AppComponent]
})
export class AppModule { }
