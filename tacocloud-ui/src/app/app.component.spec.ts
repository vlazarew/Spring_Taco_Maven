import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import {HeaderComponent} from "./header/header.component";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {APP_BASE_HREF} from "@angular/common";
import {CartComponent} from "./cart/cart.component";
import {CartService} from "./cart/cart-service";
import {routes} from "./app.routes";
import {FooterComponent} from "./footer/footer.component";
import {CloudTitleComponent} from "./cloud-title/cloudtitle.component";
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

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        RouterModule.forRoot(routes),
        BrowserModule,
        HttpModule,
        HttpClientModule,
        FormsModule
      ],
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
      providers:[
        {provide:APP_BASE_HREF, useValue:'/'},
        ApiService,
        CartService,
        RecentTacosService
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'tacocloud-ui'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('tacocloud-ui');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('tacocloud-ui app is running!');
  });
});
