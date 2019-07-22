import { Injectable } from '@angular/core';
import { PlatformLocation } from '@angular/common';
import { Bucket } from '../model/bucket.model';
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})
export class UrlProviderService {

  private readonly BUCKETS: string = '/rest/api/buckets';
  private readonly BUCKET: string = this.BUCKETS + '/:bucketId:';

  private readonly ITEMS: string = this.BUCKET + '/items';
  private readonly ITEM: string = this.ITEMS + '/:itemId:';

  constructor(private baseUrlService: PlatformLocation) { }

  private buildUrl(url: string, bucketId?: string, itemId?: string) {

    let finalUrl = url;

    if (bucketId !== undefined) {
      finalUrl = finalUrl.replace(':bucketId:', bucketId);;
    }
    if (bucketId !== undefined) {
      finalUrl = finalUrl.replace(':itemId:', itemId);
    }

    return 'http://localhost:8090' + finalUrl;
  }


  public getBucketsUrl(): string {
    return this.buildUrl(this.BUCKETS);
  }

  public getBucketUrl(bucket: Bucket): string {
    return this.buildUrl(this.BUCKET, bucket.id);
  }

  public getItemsUrl(bucket: Bucket): string {
    return this.buildUrl(this.ITEMS, bucket.id);
  }

  public getItemUrl(bucket: Bucket, item: Item): string {
    return this.buildUrl(this.ITEM, bucket.id, item.id);
  }

}
