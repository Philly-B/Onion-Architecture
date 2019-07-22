import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Bucket } from '../../../model/bucket.model';
import { BucketService } from '../../../services/bucket.service';


@Component({
  selector: 'app-bucket-remove',
  templateUrl: './bucket-remove.component.html',
  styleUrls: ['./bucket-remove.component.scss']
})
export class BucketRemoveComponent implements OnInit {

  faTrash = faTrash;
  @Input() bucket: Bucket;
  @Output() bucketDeleted: EventEmitter<string> = new EventEmitter<string>();

  constructor(private bucketService: BucketService) { }

  ngOnInit() {
  }

  execute() {
    this.bucketService.deleteBucket(this.bucket)
      .subscribe(b => this.bucketDeleted.emit(this.bucket.id));
  }

}
