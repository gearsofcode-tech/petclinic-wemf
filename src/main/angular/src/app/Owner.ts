



import {Pet} from './Pet';

export interface Owner {
	
	id: number;
	firstName: string;
	lastName: string;
	address: string;
	city: string;
	telephone: string;
	pets: Pet;
	
}