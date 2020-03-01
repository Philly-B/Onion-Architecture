import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectorRef } from '@angular/core';
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
  @Output() bucketDeleted: EventEmitter<string> = new EventEmitter<string>();
  @Output() bucketEdited: EventEmitter<Bucket> = new EventEmitter<Bucket>();
  showDetails: boolean;

  displayedColumns: string[] = ['name', 'value', 'edit', 'remove'];
  dataSource: MatTableDataSource<Item>;

  constructor() {
    this.showDetails = false;
  }

  bucketDeletedEvent(bucketId: string) {
    this.bucketDeleted.emit(bucketId);
  }

  bucketEditedEvent(bucket: Bucket) {
    this.bucketEdited.emit(bucket);
  }

  itemAddedToBucket(item: Item) {
    this.dataSource.data = this.bucket.items;
  }

  ngOnInit() {
    this.dataSource = new MatTableDataSource<Item>(this.bucket.items);
  }

  triggerShowDetails() {
    this.showDetails = !this.showDetails;
  }

}
