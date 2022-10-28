


import { Component, OnInit } from '@angular/core';
import {PetType} from '../PetType';

@Component({
  selector: 'app-PetType-list',
  templateUrl: './PetType-List.component.html',
  styleUrls: ['./PetType-List.component.css']
})
export class PetTypeListComponent implements OnInit {

  petTypeList = [] as PetType[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchPetType(){
  	alert('PetType works!');
  }

}
