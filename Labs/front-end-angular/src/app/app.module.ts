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
import {HttpClientModule} from '@angular/common/http';
import {AuthService} from './auth.service';
import {SubjService} from './subj.service';
import {TestService} from './test.service';
import { TestComponent } from './test/test.component';
import { ResultComponent } from './result/result.component';
import { CreateTestComponent } from './create-test/create-test.component';

const routes = [
  {path: '', redirectTo: '/subject', pathMatch: 'full'},
  {path: 'subject', component: SubBoardComponent},
  {path: 'subject/:id', component: TestListComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    TestListComponent,
    SubBoardComponent,
    TestComponent,
    ResultComponent,
    CreateTestComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService, SubjService, TestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
