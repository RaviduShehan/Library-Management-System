import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit{
   form3: FormGroup;
   deleteItem:any;
   val: any;
   displayDel : any;

  constructor(private http:HttpClient) {
    this.form3= new FormGroup({
      'isbn': new FormControl(null)
    });


  }
 onSubmit() {
   let deleteItem = JSON.stringify(this.form3.value);
   return this.http.post('/api/delete', deleteItem).subscribe((del: any) => {
     console.log(del);
     this.deleteItem = del;



   });
 }

  ngOnInit() {
    let val = JSON.stringify(this.form3.value);
    return this.http.post('/api/count1', val).subscribe((count1: any) => {
      console.log(count1);
      this.val = count1;
    });

  }

  displaySection(){

    let displayItem = JSON.stringify(this.form3.value);
    return this.http.post('/api/dele', displayItem).subscribe((dele: any) => {
      console.log(dele);
      this.displayDel = dele;
    });
 }



}
