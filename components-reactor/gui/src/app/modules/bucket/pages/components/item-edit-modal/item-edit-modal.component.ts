import { Component, OnInit, Inject } from '@angular/core';
import { Item } from '../../../model/item.model';
import { FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-item-edit-modal',
  templateUrl: './item-edit-modal.component.html',
  styleUrls: ['./item-edit-modal.component.scss']
})
export class ItemEditModalComponent implements OnInit {

  item: Item;
  title: string;

  FormControl: FormControl;

  constructor(private dialogRef: MatDialogRef<ItemEditModalComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any) {

    this.item = data.item;
    this.title = data.titleOfModal;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onEnter() {
    this.save();
  }

  save() {
    this.dialogRef.close(this.item);
  }

  ngOnInit() {
  }


}
