import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BucketOverviewComponent } from './pages/bucket-overview/bucket-overview.component';
import { BucketEditComponent } from './pages/components/bucket-edit/bucket-edit.component';
import { BucketRemoveComponent } from './pages/components/bucket-remove/bucket-remove.component';
import { ItemEditComponent } from './pages/components/item-edit/item-edit.component';
import { ItemRemoveComponent } from './pages/components/item-remove/item-remove.component';
import { BucketRoutingModule } from './bucket-routing.module';
import { BucketDetailComponent } from './pages/components/bucket-detail/bucket-detail.component';
import { BucketEditModalComponent } from './pages/components/bucket-edit-modal/bucket-edit-modal.component';
import { MaterialModule } from '../material-module';
import { BucketAddComponent } from './pages/components/bucket-add/bucket-add.component';
import { ItemAddComponent } from './pages/components/item-add/item-add.component';


@NgModule({
  declarations: [BucketOverviewComponent,
    BucketEditComponent,
    BucketRemoveComponent,
    ItemEditComponent,
    ItemRemoveComponent,
    BucketDetailComponent,
    BucketEditModalComponent,
    BucketAddComponent,
    ItemAddComponent],
  imports: [
    CommonModule,
    BucketRoutingModule,
    MatCardModule,
    FontAwesomeModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    BucketEditModalComponent
  ]
})
export class BucketModule {

}
