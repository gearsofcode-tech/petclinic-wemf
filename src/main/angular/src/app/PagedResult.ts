export interface PagedResult<T>{

    list: T[];
    page: number;
    pageSize: number;
    totalRecords: number;
}