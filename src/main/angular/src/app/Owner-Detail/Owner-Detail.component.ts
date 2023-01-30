


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Owner} from '../Owner';
import {OwnerService} from '../Owner.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
    selector: 'app-Owner-detail',
    templateUrl: './Owner-Detail.component.html',
    styleUrls: ['./Owner-Detail.component.css']
})
export class OwnerDetailComponent implements OnInit {

	owner : Partial<Owner> = {};

    
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
}
