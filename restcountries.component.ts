import { Component } from '@angular/core';
import { ApiserviceService } from 'src/app/services/apiservice.service';

@Component({
  selector: 'app-restcountries',
  templateUrl: './restcountries.component.html',
  styleUrls: ['./restcountries.component.css']
})
export class RestcountriesComponent {
  Response:any;
    constructor(private service:ApiserviceService){}

    ngOnInit(){
      this.service.returnFn().subscribe((response)=>{this.Response=response})
    }
    
}
