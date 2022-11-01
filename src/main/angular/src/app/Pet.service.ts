



import {PetType} from './PetType';
import {Visit} from './Visit';

import {Pet} from './Pet';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class PetService {
    items: Pet[] = [];


	getItems() {
	    return this.items;
	}
}
