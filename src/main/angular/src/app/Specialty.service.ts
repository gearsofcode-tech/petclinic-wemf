



import {Specialty} from './Specialty';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class SpecialtyService {
    items: Specialty[] = [];


	getItems() {
	    return this.items;
	}
}
