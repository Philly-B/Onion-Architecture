import { Component, OnInit, Input } from '@angular/core';
import { Bucket } from '../../../model/bucket.model';

@Component({
  selector: 'app-bucket-detail',
  templateUrl: './bucket-detail.component.html',
  styleUrls: ['./bucket-detail.component.scss']
})
export class BucketDetailComponent implements OnInit {

  @Input() bucket: Bucket;

  constructor() { }

  ngOnInit() {
  }

}
