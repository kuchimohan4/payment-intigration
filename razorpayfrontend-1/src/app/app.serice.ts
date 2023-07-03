import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class paymentservice{

    constructor(private http:HttpClient){}


    public createTransaction(amount:number){
        let url="http://localhost:8080/createOrder/";
        url=url+amount*100;
        return this.http.get(url);
    }

}