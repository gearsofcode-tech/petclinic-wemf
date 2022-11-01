



import {Pet} from './Pet';

import {Owner} from './Owner';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { PagedResult } from './PagedResult';

@Injectable({
    providedIn: 'root'
})
export class OwnerService {
    items: Owner[] = [];
    getUrl = 'http://localhost:8070/api/v1/owner/find';

    constructor(private http: HttpClient){}

	getItems(searchForm : FormGroup): Observable<PagedResult<Owner>> {
	    return this.http.post<PagedResult<Owner>>(this.getUrl, searchForm.value);
	}

}
