import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import { Bucket } from '../../../model/bucket.model';
import { BucketService } from '../../../services/bucket.service';
import { MatDialog } from '@angular/material';
import { BucketEditModalComponent } from '../bucket-edit-modal/bucket-edit-modal.component';

@Component({
  selector: 'app-bucket-edit',
  templateUrl: './bucket-edit.component.html',
  styleUrls: ['./bucket-edit.component.scss']
})
export class BucketEditComponent implements OnInit {

  faEdit = faEdit;
  @Input() bucket: Bucket;
  @Output() bucketEditEvent: EventEmitter<Bucket> = new EventEmitter<Bucket>();

  constructor(private bucketService: BucketService,
    private modalDialog: MatDialog) { }

  ngOnInit() {
  }

  execute() {
    this.openDialog();
  }

  private openDialog(): void {

    this.modalDialog.open(BucketEditModalComponent, {
      width: '250px',
      data: {
        bucket: Object.assign({}, this.bucket),
        titleOfModal: 'Edit Bucket'
      }
    }).afterClosed().subscribe(result => {
      if (result !== undefined && result.name !== this.bucket.name) {
        this.bucket.name = result.name;
        this.bucketService.updateBucket(this.bucket)
          .subscribe(this.bucketEditEvent.emit);
      }
    });

  }


}
