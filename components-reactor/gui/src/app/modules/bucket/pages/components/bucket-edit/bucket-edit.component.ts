import { Component, OnInit } from '@angular/core';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-bucket-edit',
  templateUrl: './bucket-edit.component.html',
  styleUrls: ['./bucket-edit.component.scss']
})
export class BucketEditComponent implements OnInit {

  faEdit = faEdit;

  constructor() { }

  ngOnInit() {
  }

}
