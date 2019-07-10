import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  createItem(result: any): any {
    console.log(result);
  }

  constructor() { }
}
