import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { Bucket } from '../../../model/bucket.model';
import { ItemService } from '../../../services/item.service';
import { MatDialog } from '@angular/material';
import { Item } from '../../../model/item.model';
import { ItemEditModalComponent } from '../item-edit-modal/item-edit-modal.component';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.scss']
})
export class ItemAddComponent {


  faPlus = faPlus;
  @Input() bucket: Bucket;
  @Output() bucketEdited: EventEmitter<Bucket> = new EventEmitter<Bucket>();

  constructor(
    private itemService: ItemService,
    private modalDialog: MatDialog) {
  }

  private addItemToBucket = (item: Item): void => {

    this.bucket.items.push(item);
    this.bucketEdited.emit(this.bucket);
  }

  private createNewItem = (item: Item): void => {
    if (item !== undefined) {
      this.itemService.createItem(this.bucket, item)
        .subscribe(this.addItemToBucket);
    }
  }

  execute() {

    this.modalDialog
      .open(ItemEditModalComponent, {
        width: '250px',
        data: {
          item: new Item(),
          titleOfModal: 'Create Item'
        }
      })
      .afterClosed()
      .subscribe(this.createNewItem);

  }

}
