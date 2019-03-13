import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-generate-report',
  templateUrl: './generate-report.component.html',
  styleUrls: ['./generate-report.component.css']
})
export class GenerateReportComponent implements OnInit {
 form: FormGroup;
 report: any;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    let report = JSON.stringify(this.form);
    return this.http.post('/api/report', report).subscribe((report: any) => {
      console.log(report);
      this.report = report;
    });
  }

}
