import { Component, OnInit, Input } from '@angular/core';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { Bucket } from '../../../model/bucket.model';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.scss']
})
export class ItemAddComponent implements OnInit {


  faPlus = faPlus;
  @Input()  bucket: Bucket;

  constructor() {

   }

  ngOnInit() {
  }

  execute() {
    
  }

}
