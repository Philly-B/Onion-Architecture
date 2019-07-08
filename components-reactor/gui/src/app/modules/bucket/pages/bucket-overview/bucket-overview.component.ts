import { Component, OnInit, Input } from '@angular/core';
import { BucketService } from '../../services/bucket.service';
import { Bucket } from '../../model/bucket.model';
import { Observable } from 'rxjs';
import { defaultIfEmpty, map } from 'rxjs/operators';

@Component({
  selector: 'app-bucket-overview',
  templateUrl: './bucket-overview.component.html',
  styleUrls: ['./bucket-overview.component.scss']
})
export class BucketOverviewComponent implements OnInit {

  buckets$: Observable<Bucket[]>;

  constructor(private bucketService: BucketService) {

  }

  ngOnInit() {

    this.buckets$ = this.bucketService.getBuckets();
  }

}
