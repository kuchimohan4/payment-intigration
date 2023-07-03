import { Component } from '@angular/core';
import { paymentservice } from './app.serice';
// import * as Razorpay from 'razorpay';


declare var Razorpay:any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  constructor(private paymservice:paymentservice){}
  amount:number=0;


  submited(amount:number){
    this.paymservice.createTransaction(amount).subscribe((reponce)=>{
      console.log(reponce)
      this.openTranscation(reponce);
    },(error)=>{
      console.log(error)
    });

  }
  
  openTranscation(response:any){
    var options={
      order_id:response.orderId,
      key_id:response.key,
      amount:response.amount,
      currency:response.currency,
      name:'pament for products',
      description:'payment for shoping',
      image:'https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcS1voCPUYTtXj3TlsWOrJVAzHNh1gP0c59mFXE7Ke29HmlkYZzavHNlXxmdHNHMpD7cKPLVeVigv5TFr78',
      handler:(response:any)=>{
        if(response !=null && response.razorpay_payment_id !=null){
          this.processResponce(response);
        }
        else{
          alert('payment failed')
        }
        
      },
      prefill:{
          name:'kuchi',
          email:'kuchimohan4@gmail.com',
          contact:'7993319726'
      },
      notes:{
        address:'online shoping'
      },
      theme:{
        color:'#f37254'
      }
    };

    var rozorpayobj= new Razorpay(options);
    rozorpayobj.open();

  }

  processResponce(presponce:any){
    console.log(presponce);
    

  }
  
}

