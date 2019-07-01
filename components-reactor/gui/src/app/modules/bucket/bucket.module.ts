import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BucketOverviewComponent } from './pages/bucket-overview/bucket-overview.component';
import { BucketEditComponent } from './pages/components/bucket-edit/bucket-edit.component';
import { BucketRemoveComponent } from './pages/components/bucket-remove/bucket-remove.component';
import { ItemEditComponent } from './pages/components/item-edit/item-edit.component';
import { ItemRemoveComponent } from './pages/components/item-remove/item-remove.component';
import { BucketRoutingModule } from './bucket-routing.module';

@NgModule({
  declarations: [BucketOverviewComponent,
    BucketEditComponent,
    BucketRemoveComponent,
    ItemEditComponent,
    ItemRemoveComponent],
  imports: [
    CommonModule,
    BucketRoutingModule
  ]
})
export class BucketModule { }
