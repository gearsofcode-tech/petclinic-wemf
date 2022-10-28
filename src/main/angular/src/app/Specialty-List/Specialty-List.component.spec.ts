


import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialtyListComponent } from './Specialty-List.component';

describe('SpecialtyListComponent', () => {
  let component: SpecialtyListComponent;
  let fixture: ComponentFixture<SpecialtyListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialtyListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecialtyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
