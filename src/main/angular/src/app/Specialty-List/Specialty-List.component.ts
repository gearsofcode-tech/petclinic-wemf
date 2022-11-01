


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Specialty} from '../Specialty';
import {SpecialtyService} from '../Specialty.service';

@Component({
    selector: 'app-Specialty-list',
    templateUrl: './Specialty-List.component.html',
    styleUrls: ['./Specialty-List.component.css']
})
export class SpecialtyListComponent implements OnInit {

    specialtyList : Specialty[] = this.specialtyService.getItems();
  
    constructor(
        private  specialtyService: SpecialtyService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    searchSpecialty(){
  	    alert('Specialty works!');
    }

}
