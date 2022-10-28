


import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitListComponent } from './Visit-List.component';

describe('VisitListComponent', () => {
  let component: VisitListComponent;
  let fixture: ComponentFixture<VisitListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VisitListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisitListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
