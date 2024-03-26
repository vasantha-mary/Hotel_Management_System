import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { Customer } from '../customer';
import { BookingService } from '../Service/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../Service/customer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
  id:number;
  result:number;
  customer:Customer = new Customer(0,"","","","","","");
  booking :Booking = new Booking(0,0,0,'',0);
  

  submitted: boolean = false;

  constructor(private bookingService:BookingService,private route:ActivatedRoute,private router:Router,private customerService:CustomerService){}
 
  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
    this.customerService.getCustomerById(this.id).subscribe(data=>{this.customer=data;},error=>console.log(error));
   }
 
    

    Calculate(v:number,b:number){
      this.result=v*b;
      
  
     }
     
    Book(){
      console.log(this.result);
      console.log(this.customer.employeeId);
      this.booking.totalAmount=this.result;
      console.log(this.booking);
      this.bookingService.bookRoom(this.booking).subscribe(data=>
        this.router.navigateByUrl("/dashboard/bookings"));
  
      }

      isInvalid(controlName: string, bookingForm: NgForm): boolean {
        const control = bookingForm.controls[controlName];
        return control.invalid && (control.dirty || control.touched || this.submitted);
      }
    
      getErrorMessage(controlName: string, bookingForm: NgForm): string {
        const control = bookingForm.controls[controlName];
    
        if (control && control.errors) {
          if (control.errors['required']) {
            return 'This field is required.';
          } else if (control.errors['minlength']) {
            return 'Value must be at least ' + control.errors['minlength'].requiredLength + ' characters.';
          } else if (control.errors['maxlength']) {
            return 'Value cannot exceed ' + control.errors['maxlength'].requiredLength + ' characters.';
          } else if (control.errors['min']) {
            return 'Value must be greater than or equal to ' + control.errors['min'].min + '.';
          }
        }
    
        return '';
      }
       
    }