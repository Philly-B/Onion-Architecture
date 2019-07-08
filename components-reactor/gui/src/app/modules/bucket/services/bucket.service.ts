import { Injectable } from '@angular/core';
import { Bucket } from '../model/bucket.model';
import { Observable, of } from 'rxjs';
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})
export class BucketService {
  

  private items: Item[] = [
    new Item({ id: '54', name: 'First item', value: 12.4 }),
    new Item({ id: '58', name: 'Second item', value: 153.4 })
  ];

  private buckets: Bucket[] = [
    new Bucket({ id: '12', name: 'Bla' }),
    new Bucket({ id: '15', name: 'Blub', items: this.items }),
    new Bucket({ id: '17', name: 'Blob' })
  ];

  createBucket(result: any) {
    result.id = this.getRandomInt(1000);
    this.buckets.push(result);
  }

  updateBucket(bucket: Bucket) {
    console.log('Deleting bucket', bucket);
    const index = this.buckets.findIndex(b => bucket.id === b.id );
    this.buckets[index] = bucket;
  }

  deleteBucket(bucket: Bucket) {
    console.log('Deleting bucket', bucket);
    this.buckets.splice(this.buckets.indexOf(bucket), 1);
    console.log(this.buckets);
  }

  constructor() { }

  getBuckets(): Observable<Bucket[]> {
    return of(this.buckets);
  }

  private getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

}
