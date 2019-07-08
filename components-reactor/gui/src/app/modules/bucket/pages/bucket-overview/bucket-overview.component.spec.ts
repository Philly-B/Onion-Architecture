import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BucketOverviewComponent } from './bucket-overview.component';

describe('BucketOverviewComponent', () => {
  let component: BucketOverviewComponent;
  let fixture: ComponentFixture<BucketOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BucketOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BucketOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
