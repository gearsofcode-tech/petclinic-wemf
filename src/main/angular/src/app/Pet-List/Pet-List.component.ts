


import { Component, OnInit } from '@angular/core';
import {Pet} from '../Pet';

@Component({
  selector: 'app-Pet-list',
  templateUrl: './Pet-List.component.html',
  styleUrls: ['./Pet-List.component.css']
})
export class PetListComponent implements OnInit {

  petList = [] as Pet[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchPet(){
  	alert('Pet works!');
  }

}
