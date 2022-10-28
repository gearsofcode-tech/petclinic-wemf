


import { Component, OnInit } from '@angular/core';
import {Veterinarian} from '../Veterinarian';

@Component({
  selector: 'app-Veterinarian-list',
  templateUrl: './Veterinarian-List.component.html',
  styleUrls: ['./Veterinarian-List.component.css']
})
export class VeterinarianListComponent implements OnInit {

  veterinarianList = [] as Veterinarian[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchVeterinarian(){
  	alert('Veterinarian works!');
  }

}
