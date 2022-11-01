


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Visit} from '../Visit';
import {VisitService} from '../Visit.service';

@Component({
    selector: 'app-Visit-list',
    templateUrl: './Visit-List.component.html',
    styleUrls: ['./Visit-List.component.css']
})
export class VisitListComponent implements OnInit {

    visitList : Visit[] = this.visitService.getItems();
  
    constructor(
        private  visitService: VisitService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    searchVisit(){
  	    alert('Visit works!');
    }

}
