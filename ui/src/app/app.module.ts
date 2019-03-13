import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import { RouteExampleComponent } from './route-example/route-example.component';

import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { BorrowItemComponent } from './borrow-item/borrow-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { ViewItemComponent } from './view-item/view-item.component';
import { ReturnItemComponent } from './return-item/return-item.component';
import { HomeComponent } from './home/home.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddDvDComponent } from './add-dvd/add-dv-d.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path : 'borrow-item', component: BorrowItemComponent},
  {path : 'delete-item', component: DeleteItemComponent},
  {path : 'return-item', component: ReturnItemComponent},
  {path :'view-item',component: ViewItemComponent},
  {path : 'add-books', component: AddBooksComponent},
  {path: 'add-dvd', component: AddDvDComponent},
  {path: 'generate-report',component:GenerateReportComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    RouteExampleComponent,

    BorrowItemComponent,
    DeleteItemComponent,
    ViewItemComponent,
    ReturnItemComponent,
    HomeComponent,
    AddBooksComponent,
    AddDvDComponent,
    GenerateReportComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes)
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
