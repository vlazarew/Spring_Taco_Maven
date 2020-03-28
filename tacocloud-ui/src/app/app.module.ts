import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from "./header/header.component";
import {HttpModule} from "@angular/http";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {OAuthModule} from "angular-oauth2-oidc";
import {CartService} from "./cart/cart-service";
import {routes} from "./app.routes";
import {FooterComponent} from "./footer/footer.component";
import {CloudTitleComponent} from "./cloud-title/cloudtitle.component";
import {CartComponent} from "./cart/cart.component";
import {WrapsPipe} from "./recents/WrapsPipe";
import {NonWrapsPipe} from "./recents/NonWrapsPipe";
import {ApiService} from "./api/ApiService";
import {DesignComponent} from "./design/design.component";
import {BigButtonComponent} from "./big-button/bigbutton.component";
import {GroupBoxComponent} from "./group-box/groupbox.component";
import {HomeComponent} from "./home/home.component";
import {LittleButtonComponent} from "./little-button/littlebutton.component";
import {LocationsComponent} from "./locations/locations.component";
import {LoginComponent} from "./login/login.component";
import {RecentTacosService} from "./recents/RecentTacosService";
import {RecentTacosComponent} from "./recents/recents.component";
import {SpecialsComponent} from "./specials/specials.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CloudTitleComponent,
    CartComponent,
    WrapsPipe,
    NonWrapsPipe,
    DesignComponent,
    BigButtonComponent,
    GroupBoxComponent,
    HomeComponent,
    LittleButtonComponent,
    LocationsComponent,
    LoginComponent,
    RecentTacosComponent,
    SpecialsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    // OAuthModule.forRoot()
  ],
  providers: [CartService, ApiService, RecentTacosService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
