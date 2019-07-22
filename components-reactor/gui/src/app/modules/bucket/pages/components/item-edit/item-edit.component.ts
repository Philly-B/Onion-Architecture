import { Component, OnInit, Input } from '@angular/core';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import { Item } from '../../../model/item.model';
import { Bucket } from '../../../model/bucket.model';
import { MatDialog } from '@angular/material';
import { ItemEditModalComponent } from '../item-edit-modal/item-edit-modal.component';
import { ItemService } from '../../../services/item.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.scss']
})
export class ItemEditComponent implements OnInit {

  faEdit = faEdit;
  @Input() item: Item;
  @Input() bucket: Bucket;

  constructor(private modalDialog: MatDialog,
    private itemService: ItemService) { }

  ngOnInit() {
  }

  execute() {
    this.openDialog();
  }

  private openDialog(): void {

    this.modalDialog.open(ItemEditModalComponent, {
      width: '250px',
      data: {
        item: Object.assign({}, this.item),
        titleOfModal: 'Edit Item'
      }
    }).afterClosed().subscribe(result => {
      if (result !== undefined && (result.name !== this.item.name || result.value !== this.item.value)) {
        this.item.name = result.name;
        this.item.value = result.value;
        this.itemService.updateItem(this.bucket, this.item);
      }
    });

  }

}
