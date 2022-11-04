



import {PetType} from './PetType';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import baseUrl from './baseUrl';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { PagedResult } from './PagedResult';

@Injectable({
    providedIn: 'root'
})
export class PetTypeService {
    items: PetType[] = [];
    getUrl = baseUrl() + '/api/v1/pet-type/find';


	constructor(private http: HttpClient){
        
    }

	getItems(searchForm : FormGroup): Observable<PagedResult<PetType>> {
	    return this.http.post<PagedResult<PetType>>(this.getUrl, searchForm.value);
	}
}
