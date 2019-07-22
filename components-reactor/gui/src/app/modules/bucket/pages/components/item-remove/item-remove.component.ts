import { Component, OnInit, Input } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Item } from '../../../model/item.model';
import { Bucket } from '../../../model/bucket.model';
import { ItemService } from '../../../services/item.service';

@Component({
  selector: 'app-item-remove',
  templateUrl: './item-remove.component.html',
  styleUrls: ['./item-remove.component.scss']
})
export class ItemRemoveComponent implements OnInit {

  faTrash = faTrash;
  @Input() item: Item;
  @Input() bucket: Bucket;

  constructor(private itemService: ItemService) { }

  ngOnInit() {
  }

  execute() {
    this.itemService.removeItem(this.bucket, this.item);
  }

}
