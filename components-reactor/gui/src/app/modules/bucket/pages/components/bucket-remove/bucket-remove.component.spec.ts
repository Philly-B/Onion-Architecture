import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BucketRemoveComponent } from './bucket-remove.component';

describe('BucketRemoveComponent', () => {
  let component: BucketRemoveComponent;
  let fixture: ComponentFixture<BucketRemoveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BucketRemoveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BucketRemoveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
