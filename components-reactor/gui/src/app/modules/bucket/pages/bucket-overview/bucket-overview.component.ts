import { Component, OnInit, Input } from '@angular/core';
import { BucketService } from '../../services/bucket.service';
import { Bucket } from '../../model/bucket.model';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { MatDialog } from '@angular/material';
import { BucketEditModalComponent } from '../components/bucket-edit-modal/bucket-edit-modal.component';

@Component({
  selector: 'app-bucket-overview',
  templateUrl: './bucket-overview.component.html',
  styleUrls: ['./bucket-overview.component.scss']
})
export class BucketOverviewComponent implements OnInit {

  buckets: Bucket[];
  faPlus = faPlus;

  constructor(private bucketService: BucketService,
    private modalDialog: MatDialog) {

  }

  ngOnInit() {

    this.bucketService.getBuckets()
      .subscribe(result => {
        console.log(result);
        this.buckets = result;
      }
      );
  }

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.buckets, event.previousIndex, event.currentIndex);
  }

  execute() {
    this.modalDialog.open(BucketEditModalComponent, {
      width: '250px',
      data: {
        bucket: new Bucket(),
        titleOfModal: 'Create Bucket'
      }
    }).afterClosed().subscribe(result => {
      console.log('edit modal close', result);
      if (result !== undefined) {
        this.bucketService.createBucket(result);
      }
    });
  }

}
