



import {Pet} from './Pet';

import {Owner} from './Owner';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import baseUrl from './baseUrl';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { PagedResult } from './PagedResult';

@Injectable({
    providedIn: 'root'
})
export class OwnerService {
    items: Owner[] = [];
    getUrl = baseUrl() + '/api/v1/owner/find';
    createUrl = baseUrl() + '/api/v1/owner/insert';


	constructor(private http: HttpClient){
        
    }

	getItems(searchForm : FormGroup): Observable<PagedResult<Owner>> {
	    return this.http.post<PagedResult<Owner>>(this.getUrl, searchForm.value);
	}
	
	createNew(createForm : FormGroup): Observable<Owner> {
	    return this.http.post<Owner>(this.createUrl, createForm.value);
	}
}
