import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {$} from "protractor";



@Component({
  selector: 'app-view-item',
  templateUrl: './view-item.component.html',
  styleUrls: ['./view-item.component.css']
})
export class ViewItemComponent implements OnInit {

  viewItem: any;
  form4: FormGroup;
  search: FormGroup;
  searchItems: any;

  constructor(private http: HttpClient) {
     this.search= new FormGroup({
       'title': new FormControl(null)
     });

  }

  ngOnInit() {
    let viewItem = JSON.stringify(this.form4);
    return this.http.post('/api/view', viewItem).subscribe((view: any) => {
      console.log(view);
      this.viewItem = view;
    });


  }

onSubmit(){
    let search= JSON.stringify(this.search.value);
  return this.http.post('/api/search', search).subscribe((search: any) => {
    console.log(search);
    this.searchItems = search;
  });

}

}
