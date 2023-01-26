


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Owner} from '../Owner';
import {OwnerService} from '../Owner.service';

@Component({
    selector: 'app-Owner-create',
    templateUrl: './Owner-Create.component.html',
    styleUrls: ['./Owner-Create.component.css']
})
export class OwnerCreateComponent implements OnInit {

    
    createForm = this.formBuilder.group({
        
		
		
			firstName: '',
		
		
			lastName: '',
		
		
			address: '',
		
		
			city: '',
		
		
			telephone: ''
		
    });
  
    constructor(
        private  ownerService: OwnerService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    onCreateSubmit(){
    	this.ownerService.createNew(this.createForm)
    	.subscribe(result => console.log(result));
  	    alert('Owner works!');
    }

}
