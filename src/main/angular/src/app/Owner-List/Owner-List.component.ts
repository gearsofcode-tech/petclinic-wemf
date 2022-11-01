


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Owner} from '../Owner';
import {OwnerService} from '../Owner.service';

@Component({
    selector: 'app-Owner-list',
    templateUrl: './Owner-List.component.html',
    styleUrls: ['./Owner-List.component.css']
})
export class OwnerListComponent implements OnInit {

    ownerList : Owner[] = [];
    
    searchForm = this.formBuilder.group({
			firstName: '',
			lastName: '',
            page: 1,
            pageSize: 20

    });
  
    constructor(
        private  ownerService: OwnerService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    onSearchSubmit(){
        this.ownerService.getItems(this.searchForm)
        .subscribe(owners => this.ownerList = owners.list);
  	    alert('Owner works!' + this.searchForm.value.firstName);
    }

}
