import { Injectable } from '@angular/core';
import { Bucket } from '../model/bucket.model';
import { Observable } from 'rxjs';
import { UrlProviderService } from './url-provider.service';
import { HttpClient } from '@angular/common/http';
import { HttpClientConstantsService } from 'src/app/shared/http-client-constants.service';

@Injectable({
  providedIn: 'root'
})
export class BucketService {

  getBuckets(): Observable<Bucket[]> {
    return this.httpService
      .get<Bucket[]>(this.urlProvider.getBucketsUrl(), this.httpClientConst.HTTP_OPTIONS);
  }

  createBucket(bucket: Bucket): Observable<Bucket> {
    return this.httpService.put<Bucket>(this.urlProvider.getBucketsUrl(), bucket, this.httpClientConst.HTTP_OPTIONS);
  }

  updateBucket(bucket: Bucket): Observable<Bucket> {
    return this.httpService.post<Bucket>(this.urlProvider.getBucketUrl(bucket), bucket, this.httpClientConst.HTTP_OPTIONS);
  }

  deleteBucket(bucket: Bucket): Observable<Bucket> {
    return this.httpService.delete<Bucket>(this.urlProvider.getBucketUrl(bucket));
  }

  constructor(private httpService: HttpClient,
    private urlProvider: UrlProviderService,
    private httpClientConst: HttpClientConstantsService) { }


}
