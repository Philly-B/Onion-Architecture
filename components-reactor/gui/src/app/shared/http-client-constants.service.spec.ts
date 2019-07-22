import { TestBed } from '@angular/core/testing';

import { HttpClientConstantsService } from './http-client-constants.service';

describe('HttpClientConstantsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpClientConstantsService = TestBed.get(HttpClientConstantsService);
    expect(service).toBeTruthy();
  });
});
