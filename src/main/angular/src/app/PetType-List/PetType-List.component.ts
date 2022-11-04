


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

    petTypeList : PetType[] = [];
    
    searchForm = this.formBuilder.group({
        
		
		
			name: '',
		
		page: 1,
        pageSize: 20
    });
  
    constructor(
        private  petTypeService: PetTypeService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    onSearchSubmit(){
    	this.petTypeService.getItems(this.searchForm)
        .subscribe(result => this.petTypeList = result.list);
  	    alert('PetType works!');
    }

}
