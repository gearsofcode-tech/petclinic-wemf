


import { Component, OnInit } from '@angular/core';
import {Specialty} from '../Specialty';

@Component({
  selector: 'app-Specialty-list',
  templateUrl: './Specialty-List.component.html',
  styleUrls: ['./Specialty-List.component.css']
})
export class SpecialtyListComponent implements OnInit {

  specialtyList = [] as Specialty[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchSpecialty(){
  	alert('Specialty works!');
  }

}
