



import {Specialty} from './Specialty';

import {Veterinarian} from './Veterinarian';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class VeterinarianService {
    items: Veterinarian[] = [];


	getItems() {
	    return this.items;
	}
}
