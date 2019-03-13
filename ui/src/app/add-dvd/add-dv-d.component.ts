import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-dv-d',
  templateUrl: './add-dv-d.component.html',
  styleUrls: ['./add-dv-d.component.css']
})
export class AddDvDComponent implements OnInit {
  dvdForm: FormGroup;
  val: any;
  dvds: any;

  constructor(private http: HttpClient) {
    this.dvdForm = new FormGroup({
      'isbn': new FormControl(),
      'title': new FormControl(null),
      'section': new FormControl(null),
      'languages': new FormControl(null),
      'subtitles': new FormControl(null),
      'producer': new FormControl(null),
      'actors': new FormControl(null)
    });
  }

  ngOnInit() {

    let val = JSON.stringify(this.dvdForm.value);
    return this.http.post('/api/count', val).subscribe((count: any) => {
      console.log(count);
      this.val = count;
    });


  }


  onAction() {
    let dvds = JSON.stringify(this.dvdForm.value);
    return this.http.post('/api/dvd', dvds).subscribe((dvd: any) => {
      console.log(dvd);
      ;
      this.dvds = dvd;
    });

  }
}
