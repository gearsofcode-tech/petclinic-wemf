


import { Component, OnInit } from '@angular/core';
import {Visit} from '../Visit';

@Component({
  selector: 'app-Visit-list',
  templateUrl: './Visit-List.component.html',
  styleUrls: ['./Visit-List.component.css']
})
export class VisitListComponent implements OnInit {

  visitList = [] as Visit[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchVisit(){
  	alert('Visit works!');
  }

}
