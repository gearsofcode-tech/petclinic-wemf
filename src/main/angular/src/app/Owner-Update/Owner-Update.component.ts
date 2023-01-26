


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Owner} from '../Owner';
import {OwnerService} from '../Owner.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
    selector: 'app-Owner-update',
    templateUrl: './Owner-Update.component.html',
    styleUrls: ['./Owner-Update.component.css']
})
export class OwnerUpdateComponent implements OnInit {

	owner : Partial<Owner> = {};
    
    updateForm = this.formBuilder.group({
    	id : 0,
        
		
		
			firstName: '',
		
		
			lastName: '',
		
		
			address: '',
		
		
			city: '',
		
		
			telephone: ''
		
    });
    
    id = 0;
  
    constructor(
    	private route: ActivatedRoute,
        private router: Router,
        private  ownerService: OwnerService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    	this.route.paramMap.subscribe(
            (params) => this.id = Number(params.get('id'))
        );
        alert("id = " + this.id);
        this.ownerService.getItem(this.id).subscribe(
            owner => {this.owner = owner; console.log(owner)}
        );
    }
  
  
    onUpdateSubmit(){
    	this.ownerService.update(this.updateForm)
    	.subscribe(result => console.log(result));
  	    alert('Owner works!');
    }

}
