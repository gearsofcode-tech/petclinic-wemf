



import {PetType} from './PetType';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class PetTypeService {
    items: PetType[] = [];


	getItems() {
	    return this.items;
	}
}
