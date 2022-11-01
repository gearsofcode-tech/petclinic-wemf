


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {PetType} from '../PetType';
import {PetTypeService} from '../PetType.service';

@Component({
    selector: 'app-PetType-list',
    templateUrl: './PetType-List.component.html',
    styleUrls: ['./PetType-List.component.css']
})
export class PetTypeListComponent implements OnInit {


    petTypeList : PetType[] = this.petTypeService.getItems();

    searchForm = this.formBuilder.group({
        name: ''
    });
  
    constructor(
        private  petTypeService: PetTypeService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    onSearchSubmit(){
  	    alert('PetType' + this.searchForm.value.name );
    }

}
