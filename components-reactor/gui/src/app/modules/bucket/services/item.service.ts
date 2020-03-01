import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bucket } from '../model/bucket.model';
import { Item } from '../model/item.model';
import { Observable } from 'rxjs';
import { HttpClientConstantsService } from 'src/app/shared/http-client-constants.service';
import { UrlProviderService } from './url-provider.service';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  removeItem(bucket: Bucket, item: Item) {
    this.httpService.delete(this.urlProvider.getItemUrl(bucket, item));
  }

  updateItem(bucket: Bucket, item: Item): Observable<Item> {
    return this.httpService.post<Item>(this.urlProvider.getItemUrl(bucket, item), item, this.httpClientConst.HTTP_OPTIONS)
  }

  createItem(bucket: Bucket, item: Item): Observable<Item> {
    return this.httpService.put<Item>(this.urlProvider.getItemsUrl(bucket), item, this.httpClientConst.HTTP_OPTIONS);
  }

  constructor(
    private httpService: HttpClient,
    private urlProvider: UrlProviderService,
    private httpClientConst: HttpClientConstantsService) { }
}
