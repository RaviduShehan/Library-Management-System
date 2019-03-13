import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {
  bookForm: FormGroup;
  books: any;
  val:any;

  // constructor for AddBooks components
  constructor(private http: HttpClient) {
    this.bookForm = new FormGroup({
      'isbn': new FormControl(null),
      'title': new FormControl(null),
      'section': new FormControl(null),
      'publishedDate': new FormControl(null),
      'author': new FormControl(null),
      'publisher': new FormControl(null),
      'totalPages': new FormControl(null)
    });


  }

//This default method will load in the UI when user refreshes the site
  ngOnInit() {

    let val = JSON.stringify(this.bookForm.value);
    return this.http.post('/api/count', val).subscribe((count: any) => {
      console.log(count);
      this.val = count;
    });


  }


  onAction() {
    let books = JSON.stringify(this.bookForm.value);
    return this.http.post('/api/add', books).subscribe((book: any) => {
      console.log(book);
      this.books = book;
    });


  }
}
