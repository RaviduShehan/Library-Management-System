import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ForEachCommentCallback} from "tslint";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-borrow-item',
  templateUrl: './borrow-item.component.html',
  styleUrls: ['./borrow-item.component.css']
})
export class BorrowItemComponent  {
   borrowForm: FormGroup;
   borrowItem: any;

  constructor(private http: HttpClient) {
    this.borrowForm = new FormGroup({
      'isbn': new FormControl(null),
      'id': new FormControl(null),
      'name': new FormControl(null),
      'email': new FormControl(null),
      'mobile': new FormControl(null),
      'date': new FormControl(null)
    });

  }
 onSubmit(){
    let borrowItem = JSON.stringify(this.borrowForm.value);
    return this.http.post('/api/borrow', borrowItem).subscribe((borrow: any) => {
      console.log(borrow);
      this.borrowItem =borrow;
    });


 }


}
