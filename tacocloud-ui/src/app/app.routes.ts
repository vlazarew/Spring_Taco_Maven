import {Routes} from "@angular/router";
import {CartComponent} from "./cart/cart.component";
import {HomeComponent} from "./home/home.component";
import {DesignComponent} from "./design/design.component";
import {LocationsComponent} from "./locations/locations.component";
import {LoginComponent} from "./login/login.component";
import {RecentTacosService} from "./recents/RecentTacosService";
import {RecentTacosComponent} from "./recents/recents.component";
import {SpecialsComponent} from "./specials/specials.component";

export const routes: Routes = [
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'locations',
    component: LocationsComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'design',
    component: DesignComponent
  },
  {
    path: 'recents',
    component: RecentTacosComponent
  },
  {
    path: 'specials',
    component: SpecialsComponent
  },
  {
    path: "**",
    redirectTo: 'home',
    pathMatch: 'full'
  }
];
