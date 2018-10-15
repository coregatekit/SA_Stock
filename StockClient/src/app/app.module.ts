import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MatMenuModule } from '@angular/material/menu';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSelectModule } from '@angular/material/select';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTabsModule } from '@angular/material/tabs';

import { StockComponent } from './stock/stock.component';
import { StockService } from './shared/stock/stock.service';
import { RegisterComponent } from './register/register.component';
import { RegisterService } from './shared/register/register.service';

const appRoutes: Routes = [
  {path: 'Stock', component: StockComponent},
  {path: 'Register', component: RegisterComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    StockComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatMenuModule,
    MatGridListModule,
    MatTooltipModule,
    MatSelectModule,
    MatExpansionModule,
    MatTabsModule
  ],
  providers: [StockService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
