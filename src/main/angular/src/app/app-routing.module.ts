import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OwnerCreateComponent } from './Owner-Create/Owner-Create.component';
import { OwnerUpdateComponent } from './Owner-Update/Owner-Update.component';
import { OwnerListComponent } from './Owner-List/Owner-List.component';

const routes: Routes = [
    {path : 'owner/list', component : OwnerListComponent},
    {path : 'owner/create', component : OwnerCreateComponent},
    {path : 'owner/update/:id', component : OwnerUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
