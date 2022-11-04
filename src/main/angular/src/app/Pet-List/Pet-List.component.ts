


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

    petList : Pet[] = [];
    
    searchForm = this.formBuilder.group({
        
		
		
			name: '',
		
		
		page: 1,
        pageSize: 20
    });
  
    constructor(
        private  petService: PetService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    onSearchSubmit(){
    	this.petService.getItems(this.searchForm)
        .subscribe(result => this.petList = result.list);
  	    alert('Pet works!');
    }

}
