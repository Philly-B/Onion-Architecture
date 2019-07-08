import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BucketEditModalComponent } from './bucket-edit-modal.component';

describe('BucketEditModalComponent', () => {
  let component: BucketEditModalComponent;
  let fixture: ComponentFixture<BucketEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BucketEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BucketEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
