



import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { OwnerListComponent } from './Owner-List/Owner-List.component';
import { VeterinarianListComponent } from './Veterinarian-List/Veterinarian-List.component';
import { PetListComponent } from './Pet-List/Pet-List.component';
import { PetTypeListComponent } from './PetType-List/PetType-List.component';
import { SpecialtyListComponent } from './Specialty-List/Specialty-List.component';
import { VisitListComponent } from './Visit-List/Visit-List.component';


@NgModule({
  declarations: [
    AppComponent,
    
    OwnerListComponent,
    VeterinarianListComponent,
    PetListComponent,
    PetTypeListComponent,
    SpecialtyListComponent,
    VisitListComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }