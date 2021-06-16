import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { TestListComponent } from './test-list/test-list.component';
import { PassTestComponent } from './pass-test/pass-test.component';
import { TestResultComponent } from './test-result/test-result.component';
import { CreateTestComponent } from './create-test/create-test.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    TestListComponent,
    PassTestComponent,
    TestResultComponent,
    CreateTestComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
