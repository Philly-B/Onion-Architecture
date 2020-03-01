import { Component, OnInit, Input } from '@angular/core';
import { BucketService } from '../../services/bucket.service';
import { Bucket } from '../../model/bucket.model';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { MatDialog } from '@angular/material';
import { BucketEditModalComponent } from '../components/bucket-edit-modal/bucket-edit-modal.component';
import { Observable } from 'rxjs';
import { NotifyService } from 'src/app/shared/notify.service';

@Component({
  selector: 'app-bucket-overview',
  templateUrl: './bucket-overview.component.html',
  styleUrls: ['./bucket-overview.component.scss']
})
export class BucketOverviewComponent implements OnInit {

  buckets: Bucket[];
  faPlus = faPlus;

  constructor(
    private bucketService: BucketService,
    private modalDialog: MatDialog,
    private notifyService: NotifyService) {

  }

  ngOnInit() {
    this.buckets = [];
    this.bucketService.getBuckets()
      .subscribe(bs => this.buckets = bs);
  }

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.buckets, event.previousIndex, event.currentIndex);
  }

  removeBucketFromList(bucketId: string) {
    const indexInBuckets = this.buckets.findIndex(b => b.id === bucketId);
    if (indexInBuckets !== -1) {
      const removedBuckets = this.buckets.splice(indexInBuckets, 1);
      this.notifyService.showSnackBar("Bucket '" + removedBuckets[0].name + "' removed successfully.")
    }
  }

  updateBucket(bucket: Bucket) {
    const indexInBuckets = this.buckets.findIndex(b => b.id === bucket.id);
    if (indexInBuckets !== -1) {
      this.buckets[indexInBuckets] = bucket;
    }
  }

   createBucket = (bucket: Bucket): void => {
    if (bucket !== undefined) {
      this.bucketService.createBucket(bucket)
        .subscribe(newBucket => {
          this.buckets.push(newBucket);
          this.notifyService.showSnackBar("Bucket '" + newBucket.name + "' created successfully.")
        });
    }
  }

  execute() {
    this.modalDialog.open(BucketEditModalComponent, {
      width: '250px',
      data: {
        bucket: new Bucket(),
        titleOfModal: 'Create Bucket'
      }
    }).afterClosed()
    .subscribe(this.createBucket);
  }

}
