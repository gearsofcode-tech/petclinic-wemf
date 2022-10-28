


import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeterinarianListComponent } from './Veterinarian-List.component';

describe('VeterinarianListComponent', () => {
  let component: VeterinarianListComponent;
  let fixture: ComponentFixture<VeterinarianListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VeterinarianListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeterinarianListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
