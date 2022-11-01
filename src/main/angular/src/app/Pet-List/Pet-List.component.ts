


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Pet} from '../Pet';
import {PetService} from '../Pet.service';

@Component({
    selector: 'app-Pet-list',
    templateUrl: './Pet-List.component.html',
    styleUrls: ['./Pet-List.component.css']
})
export class PetListComponent implements OnInit {

    petList : Pet[] = this.petService.getItems();
  
    constructor(
        private  petService: PetService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    searchPet(){
  	    alert('Pet works!');
    }

}
