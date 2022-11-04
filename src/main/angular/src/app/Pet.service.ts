



import {PetType} from './PetType';
import {Visit} from './Visit';

import {Pet} from './Pet';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import baseUrl from './baseUrl';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { PagedResult } from './PagedResult';

@Injectable({
    providedIn: 'root'
})
export class PetService {
    items: Pet[] = [];
    getUrl = baseUrl() + '/api/v1/pet/find';


	constructor(private http: HttpClient){
        
    }

	getItems(searchForm : FormGroup): Observable<PagedResult<Pet>> {
	    return this.http.post<PagedResult<Pet>>(this.getUrl, searchForm.value);
	}
}
