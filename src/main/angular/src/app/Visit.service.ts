



import {Visit} from './Visit';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class VisitService {
    items: Visit[] = [];


	getItems() {
	    return this.items;
	}
}
