import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { CarListComponent } from './car-list.component';
import { PartListComponent } from './part-list.component';

import { CarService } from './car.service';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    PartListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent],
})
export class AppModule { }
