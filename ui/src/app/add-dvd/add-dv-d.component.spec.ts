import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDvDComponent } from './add-dv-d.component';

describe('AddDvDComponent', () => {
  let component: AddDvDComponent;
  let fixture: ComponentFixture<AddDvDComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDvDComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDvDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
