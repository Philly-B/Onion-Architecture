import { Component, OnInit, Input } from '@angular/core';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import { Item } from '../../../model/item.model';
import { Bucket } from '../../../model/bucket.model';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.scss']
})
export class ItemEditComponent implements OnInit {

  faEdit = faEdit;
  @Input() item: Item;
  @Input() bucket: Bucket;

  constructor() { }

  ngOnInit() {
  }

  execute() {
    console.log('Edit item', this.item);
  }

}
