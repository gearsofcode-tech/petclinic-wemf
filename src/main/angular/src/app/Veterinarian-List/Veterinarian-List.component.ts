


import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Veterinarian} from '../Veterinarian';
import {VeterinarianService} from '../Veterinarian.service';

@Component({
    selector: 'app-Veterinarian-list',
    templateUrl: './Veterinarian-List.component.html',
    styleUrls: ['./Veterinarian-List.component.css']
})
export class VeterinarianListComponent implements OnInit {

    veterinarianList : Veterinarian[] = this.veterinarianService.getItems();
  
    constructor(
        private  veterinarianService: VeterinarianService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
    }
  
  
    searchVeterinarian(){
  	    alert('Veterinarian works!');
    }

}
