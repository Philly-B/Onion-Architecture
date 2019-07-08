import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BucketOverviewComponent } from './pages/bucket-overview/bucket-overview.component';

const bucketRoutes: Routes = [
  { path: 'buckets', component: BucketOverviewComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(bucketRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class BucketRoutingModule {
}
