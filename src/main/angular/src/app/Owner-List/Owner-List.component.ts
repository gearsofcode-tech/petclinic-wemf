


import { Component, OnInit } from '@angular/core';
import {Owner} from '../Owner';

@Component({
  selector: 'app-Owner-list',
  templateUrl: './Owner-List.component.html',
  styleUrls: ['./Owner-List.component.css']
})
export class OwnerListComponent implements OnInit {

  ownerList = [] as Owner[];
  
  constructor() { }

  ngOnInit(): void {
  }
  
  
  searchOwner(){
  	alert('Owner works!');
  }

}
