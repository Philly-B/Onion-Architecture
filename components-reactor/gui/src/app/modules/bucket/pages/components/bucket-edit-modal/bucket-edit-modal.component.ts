import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { Bucket } from '../../../model/bucket.model';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-bucket-edit-modal',
  templateUrl: './bucket-edit-modal.component.html',
  styleUrls: ['./bucket-edit-modal.component.scss']
})
export class BucketEditModalComponent implements OnInit {

  bucket: Bucket;

  FormControl: FormControl;

  constructor(
    public dialogRef: MatDialogRef<BucketEditModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Bucket) {

      this.bucket = data;
    }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
