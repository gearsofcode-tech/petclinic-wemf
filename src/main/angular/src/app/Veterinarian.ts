



import {Specialty} from './Specialty';

export interface Veterinarian {
	
	id: number;
	firstName: string;
	lastName: string;
	specialties: Specialty;
	
}