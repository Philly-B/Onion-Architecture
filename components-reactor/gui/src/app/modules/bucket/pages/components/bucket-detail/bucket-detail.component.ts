import { Component, OnInit, Input } from '@angular/core';
import { Bucket } from '../../../model/bucket.model';
import { Item } from '../../../model/item.model';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-bucket-detail',
  templateUrl: './bucket-detail.component.html',
  styleUrls: ['./bucket-detail.component.scss']
})
export class BucketDetailComponent implements OnInit {

  @Input() bucket: Bucket;
  showDetails: boolean;

  displayedColumns: string[] = ['name', 'value', 'edit', 'remove'];
  dataSource;

  constructor() {
    this.showDetails = false;
  }

  ngOnInit() {
    this.dataSource = new MatTableDataSource<Item>(this.bucket.items);
  }


  triggerShowDetails() {
    this.showDetails = !this.showDetails;
    console.log(this.showDetails);
  }

}
