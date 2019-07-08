export class Item {

  id: string;
  name: string;
  value: number;

  constructor(item: any = {}) {
    this.id = item.id;
    this.name = item.name;
    this.value = item.value;
  }
}
