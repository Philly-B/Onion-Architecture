import { Component, OnInit, Input } from '@angular/core';
import { BucketService } from '../../services/bucket.service';
import { Bucket } from '../../model/bucket.model';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-bucket-overview',
  templateUrl: './bucket-overview.component.html',
  styleUrls: ['./bucket-overview.component.scss']
})
export class BucketOverviewComponent implements OnInit {

  buckets: Bucket[];
  faPlus = faPlus;

  constructor(private bucketService: BucketService) {

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
    console.log('Add bucket');
  }

}
