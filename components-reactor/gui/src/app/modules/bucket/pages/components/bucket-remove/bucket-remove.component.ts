import { Component, OnInit } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-bucket-remove',
  templateUrl: './bucket-remove.component.html',
  styleUrls: ['./bucket-remove.component.scss']
})
export class BucketRemoveComponent implements OnInit {

  faTrash = faTrash;

  constructor() { }

  ngOnInit() {
  }

}
