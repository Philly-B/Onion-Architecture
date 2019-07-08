import { Component, OnInit, Input } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Item } from '../../../model/item.model';
import { Bucket } from '../../../model/bucket.model';

@Component({
  selector: 'app-item-remove',
  templateUrl: './item-remove.component.html',
  styleUrls: ['./item-remove.component.scss']
})
export class ItemRemoveComponent implements OnInit {

  faTrash = faTrash;
  @Input() item: Item;
  @Input() bucket: Bucket;

  constructor() { }

  ngOnInit() {
  }

  execute() {
    console.log('Remove item', this.item);
  }

}
