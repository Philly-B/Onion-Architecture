import { Injectable } from '@angular/core';
import { Bucket } from '../model/bucket.model';
import { Observable, of } from 'rxjs';
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})
export class BucketService {

  constructor() { }

  getBuckets(): Observable<Bucket[]> {

    var items: Item[] = [
      new Item({ id: '54', name: 'First item', value: 12.4 }),
      new Item({ id: '58', name: 'Second item', value: 153.4 })
    ];

    var buckets: Bucket[] = [
      new Bucket({ id: '12', name: 'Bla' }),
      new Bucket({ id: '15', name: 'Blub', items: items }),
      new Bucket({ id: '17', name: 'Blob' })
    ];
    return of(buckets);
  }
}
