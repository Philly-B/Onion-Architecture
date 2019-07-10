import { Component, OnInit, Input } from '@angular/core';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { Bucket } from '../../../model/bucket.model';
import { ItemService } from '../../../services/item.service';
import { MatDialog } from '@angular/material';
import { BucketEditModalComponent } from '../bucket-edit-modal/bucket-edit-modal.component';
import { Item } from '../../../model/item.model';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.scss']
})
export class ItemAddComponent implements OnInit {


  faPlus = faPlus;
  @Input() bucket: Bucket;

  constructor(private itemService: ItemService,
    private modalDialog: MatDialog) {

  }

  ngOnInit() {
  }

  execute() {

    this.modalDialog.open(BucketEditModalComponent, {
      width: '250px',
      data: {
        item: new Item(),
        titleOfModal: 'Create Bucket'
      }
    }).afterClosed().subscribe(result => {
      console.log('edit modal close', result);
      if (result !== undefined) {
        this.itemService.createItem(result);
      }
    });

  }

}
