import { Item } from './item.model';

export class Bucket {

  id: string;
  name: string;
  items: Item[];

  constructor(bucket: any = {}) {
    this.id = bucket.id;
    this.name = bucket.name;
    if (bucket.items === undefined || bucket.items === null) {
      this.items = [];
    } else {
      this.items = bucket.items;
    }
  }

}
