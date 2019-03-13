import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-return-item',
  templateUrl: './return-item.component.html',
  styleUrls: ['./return-item.component.css']
})
export class ReturnItemComponent implements OnInit {
  returnForm : FormGroup;
  returnItem : any;
  constructor(private http:HttpClient) {
    this.returnForm = new FormGroup({
      'isbn':new FormControl(null),
      'id': new FormControl(null),
      'date': new FormControl(null)
    })
  }

  ngOnInit() {
  }

  onSubmit(){
    let returnItem = JSON.stringify(this.returnForm.value);
    return this.http.post('/api/return', returnItem).subscribe((ret: any) => {
      console.log(ret);
      this.returnItem =ret;
    });
  }
}
