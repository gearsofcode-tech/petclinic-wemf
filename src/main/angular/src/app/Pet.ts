



import {PetType} from './PetType';
import {Visit} from './Visit';

export interface Pet {
	
	id: number;
	name: string;
	birthDate: number;
	type: PetType;
	visits: Visit;
	
}